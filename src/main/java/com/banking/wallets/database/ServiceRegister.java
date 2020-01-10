package com.banking.wallets.database;


import com.banking.wallets.DTO.RequestRegister;
import com.banking.wallets.entities.Users;
import com.banking.wallets.entities.Wallet;
import com.banking.wallets.repositiries.UsersRepositories;
import com.banking.wallets.repositiries.WalletRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRegister {
    @Autowired
    UsersRepositories usersRepositories;
    @Autowired
    WalletRepositories walletRepositories;
    public void saveDatabaseUsers(RequestRegister requestRegister){
        Users users = new Users();
        Wallet wallet = new Wallet();

        users.setUsername(requestRegister.getUsername());
        users.setPassword(requestRegister.getPassword());
        users.setName(requestRegister.getName());
        users.setEmail(requestRegister.getEmail());

        wallet.setUsersFk(users);
        wallet.setMoney(requestRegister.getAddmoney());

        usersRepositories.saveAndFlush(users);
        walletRepositories.save(wallet);
    }

    public boolean checkUser(String username){
        Users users = usersRepositories.findByUsername(username);
        if(users == null)
            return true;
        else
            return false;
    }


}
