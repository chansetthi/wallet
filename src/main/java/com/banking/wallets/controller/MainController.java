package com.banking.wallets.controller;

import com.banking.wallets.DTO.*;
import com.banking.wallets.database.*;
import com.banking.wallets.entities.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class MainController {

    @Autowired
    ServiceRegister serviceRegister;
    @Autowired
    ServiceResponse serviceResponse;
    @Autowired
    ServiceAddMoney serviceAddMoney;
    @Autowired
    ServiceWithdrawMoney serviceWithdrawMoney;
    @Autowired
    ServiceTransferMoney serviceTransferMoney;

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @PostMapping("/checkuser")
    public ResponseRegister checkUser(@RequestBody RequestCheckUser requestCheckUser){
        boolean check =  serviceRegister.checkUser(requestCheckUser.getUserName());
        return serviceResponse.responsecheckuser(check,requestCheckUser);
    }

    //    Addmoney
    @PostMapping("/addmoney")
    public ResponseAddmoney addmoney(@RequestBody RequestAddmoney requestAddmoney, @RequestHeader String user, @RequestHeader String pass){
        serviceAddMoney.saveAddMoney(requestAddmoney,user,pass);
        return serviceResponse.responseAddmoney(requestAddmoney,user,pass);
    }

    //    WithdrawMoney
    @PostMapping("/withdraw")
    public ResponseWithdrawMoney withdrawMoney(@RequestBody RequestWithdraw requestWithdraw , @RequestHeader String user, @RequestHeader String pass){
        logger.info("Start Witdraw");
        Wallet wallet = serviceWithdrawMoney.saveWidthdrawMoney(requestWithdraw,user,pass);
        logger.info("End Witdraw");
        return serviceResponse.responseWithdrawMoney(requestWithdraw,user,pass,wallet.getMoney());
    }

    //transfer
    @PostMapping("/transfer")
    public ResponseTransfer responseTransfer(@RequestBody RequestTransfer requestTransfer ,@RequestHeader String user, @RequestHeader String pass){
        Wallet wallet = serviceTransferMoney.saveTransferMoney(requestTransfer,user,pass);
        return  serviceResponse.responseTransfer(requestTransfer,user,pass,wallet.getMoney());
    }

    //    RregisterAccount
    @PostMapping("/register")
    public ResponseRegister registerAccount(@RequestBody RequestRegister requestRegister){
        boolean check = serviceRegister.checkUser(requestRegister.getUsername());
        ResponseRegister response = serviceResponse.responseRegister(requestRegister,check);
        if (check){
            serviceRegister.saveDatabaseUsers(requestRegister);
        }
        return response;
    }
//    ResponseHistory
    @PostMapping("/history")
    public ResponseHistory responseHistory(@RequestBody RequestHistory requestHistory) throws ParseException {
        return serviceResponse.responseHistory(requestHistory);
    }
}