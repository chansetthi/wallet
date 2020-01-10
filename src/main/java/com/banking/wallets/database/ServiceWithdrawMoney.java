package com.banking.wallets.database;


import com.banking.wallets.DTO.RequestWithdraw;
import com.banking.wallets.entities.Users;
import com.banking.wallets.entities.Wallet;
import com.banking.wallets.repositiries.HistoryRepositories;
import com.banking.wallets.repositiries.UsersRepositories;
import com.banking.wallets.repositiries.WalletRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceWithdrawMoney {
    @Autowired
    UsersRepositories usersRepositories;
    @Autowired
    WalletRepositories walletRepositories;
    @Autowired
    ServiceHistory serviceHistory;

    public Wallet saveWidthdrawMoney(RequestWithdraw requestWithdraw, String user , String password){
        Users users = usersRepositories.findByUsernameAndPassword(user,password);
        Wallet wallet = walletRepositories.findByUsersFk(users);
        wallet.setMoney(String.valueOf(Double.valueOf(wallet.getMoney()) - Double.valueOf(requestWithdraw.getWithdrawMoney())));
        walletRepositories.save(wallet);

        serviceHistory.saveHistory("wedthdraw",users.getUsername(),"",requestWithdraw.getWithdrawMoney());

        return  wallet;
    }

}
