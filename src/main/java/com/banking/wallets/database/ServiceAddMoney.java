package com.banking.wallets.database;


import com.banking.wallets.DTO.RequestAddmoney;
import com.banking.wallets.entities.Users;
import com.banking.wallets.entities.Wallet;
import com.banking.wallets.repositiries.UsersRepositories;
import com.banking.wallets.repositiries.WalletRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Logger;

@Service
public class ServiceAddMoney {
    @Autowired
    WalletRepositories walletRepositories;
    @Autowired
    UsersRepositories usersRepositories;

    private static Logger logger = Logger.getLogger(ServiceAddMoney.class.getName());

    @Autowired
    ServiceHistory serviceHistory;

    public void saveAddMoney(RequestAddmoney requestAddmoney, String name, String password){
        Users unameandpword = usersRepositories.findByUsernameAndPassword(name,password);
        Wallet wallet = walletRepositories.findByUsersFk(unameandpword);
        if (unameandpword != null){
            wallet.setMoney(String.valueOf(Double.valueOf(requestAddmoney.getAddmoney())+ Double.valueOf(wallet.getMoney())));
            walletRepositories.save(wallet);
            logger.info("save done");
            serviceHistory.saveHistory("add",unameandpword.getUsername(),"",requestAddmoney.getAddmoney());

        }
    }
}
