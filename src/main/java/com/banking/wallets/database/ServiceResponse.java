package com.banking.wallets.database;

import com.banking.wallets.DTO.*;
import com.banking.wallets.entities.History;
import com.banking.wallets.entities.Users;
import com.banking.wallets.entities.Wallet;
import com.banking.wallets.repositiries.HistoryRepositories;
import com.banking.wallets.repositiries.UsersRepositories;
import com.banking.wallets.repositiries.WalletRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServiceResponse {
    @Autowired
    WalletRepositories walletRepositories;
    @Autowired
    UsersRepositories usersRepositories;
    @Autowired
    ServiceRegister serviceRegister;
    @Autowired
    HistoryRepositories historyRepositories;



//    ResponseRegister
    public ResponseRegister responseRegister(RequestRegister requestRegister, boolean check){
        ResponseRegister response = new ResponseRegister();
//        boolean check =  serviceRegister.checkUser(requestRegister.getUsername());
        if(check) {
            response.setResultCode("0000");
            response.setResultMessage("SUCCESS");
            response.setUsername(requestRegister.getUsername());
            response.setTotalAmount(requestRegister.getAddmoney());
        }else{
            response.setResultCode("9999");
            response.setResultMessage("Entered name is already used.");
            response.setUsername(requestRegister.getUsername());
            response.setTotalAmount(requestRegister.getAddmoney());
        }
        return response;
    }
//    Responsecheckuser
    public ResponseRegister responsecheckuser(boolean check, RequestCheckUser requestCheckUser){
        ResponseRegister response = new ResponseRegister();
        if(check) {
            response.setResultCode("0000");
            response.setResultMessage("have a user");
            response.setUsername(requestCheckUser.getUserName());
        }else{
            response.setResultCode("9999");
            response.setResultMessage("not have a user");
            response.setUsername(requestCheckUser.getUserName());
        }
        return response;
    }
//    ResponseAddmoney
    public ResponseAddmoney responseAddmoney(RequestAddmoney requestAddmoney, String name, String password){
        ResponseAddmoney response = new ResponseAddmoney();

            response.setResultCode("0000");
            response.setResultMessage("SUCCESS");
            response.setUsername(requestAddmoney.getUsername());
            response.setAddmoney(requestAddmoney.getAddmoney());
            Users qwe = usersRepositories.findByUsernameAndPassword(name, password);
            Wallet total = walletRepositories.findByUsersFk(qwe);
            response.setTotalAmount(total.getMoney());

        return response;
    }
//    ResponseWithdrawMoney
    public ResponseWithdrawMoney responseWithdrawMoney(RequestWithdraw requestWithdraw, String name , String pass, String totalAmount){
        ResponseWithdrawMoney response = new ResponseWithdrawMoney();
        response.setResultCode("0000");
        response.setResultMessage("SUCCESS");
        response.setUsername(requestWithdraw.getUsername());
        response.setWithdrawMoney(requestWithdraw.getWithdrawMoney());
        response.setTotalAmont(totalAmount);
        return response;
    }
//    ResponseTransfer
    public ResponseTransfer responseTransfer(RequestTransfer requestTransfer, String uname, String pass , String tottalAmount){
        ResponseTransfer response = new ResponseTransfer();
        response.setResultCode("0000");
        response.setResultMessage("SUCCESS");
        response.setUsername(uname);
        response.setTransferMoney(requestTransfer.getTransferMoney());
        response.setTotalAmount(tottalAmount);

        return  response;
    }
//    ResponseHistory
    public ResponseHistory responseHistory(RequestHistory requestHistory) throws ParseException {
        ResponseHistory response = new ResponseHistory();
        SimpleDateFormat format = new SimpleDateFormat("ddMyyyy HH:mm:ss");
        Date date = format.parse (requestHistory.getStartDate());

        List<History> historys = historyRepositories.findAllByPayer(requestHistory.getUsername());
        List<ResponseListHistory> responseListHistories = new ArrayList<>();
        for(History history : historys){
            ResponseListHistory responseListHistory = new ResponseListHistory();
            responseListHistory.setAction(history.getAction());
            responseListHistory.setDate(history.getDate());
            responseListHistory.setPayer(history.getPayer());
            responseListHistory.setReciver(history.getRecelver());
            responseListHistory.setMoney(history.getMoney());
            responseListHistories.add(responseListHistory);
        }
        response.setResultCode("");
        response.setResultMessage("");
        response.setStartDate(requestHistory.getStartDate());
        response.setEndDate(requestHistory.getEndDate());
        response.setTotalAmount("");
        response.setHistory(responseListHistories);
        return response;
    }
}
