package com.banking.wallets.database;


import com.banking.wallets.DTO.RequestTransfer;
import com.banking.wallets.entities.Users;
import com.banking.wallets.entities.Wallet;
import com.banking.wallets.repositiries.UsersRepositories;
import com.banking.wallets.repositiries.WalletRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceTransferMoney {
    @Autowired
    UsersRepositories usersRepositories;
    @Autowired
    WalletRepositories walletRepositories;
    @Autowired
    ServiceHistory serviceHistory;

    public Wallet saveTransferMoney(RequestTransfer requestTransfer, String user, String pass){
        Users users1 = usersRepositories.findByUsernameAndPassword(requestTransfer.getPayer(),pass);
        Wallet wallet1 = walletRepositories.findByUsersFk(users1);

        Users users2 = usersRepositories.findByUsername(requestTransfer.getReceiver());
        Wallet wallet2 = walletRepositories.findByUsersFk(users2);

        wallet1.setMoney(
                String.valueOf(
                        Double.valueOf(wallet1.getMoney()) - Double.valueOf(requestTransfer.getTransferMoney())
                )
        );
        wallet2.setMoney(
                String.valueOf(
                        Double.valueOf(wallet2.getMoney()) + Double.valueOf(requestTransfer.getTransferMoney())
                )
        );

        List<Wallet> walletList = new ArrayList<>();
        walletList.add(wallet1);
        walletList.add(wallet2);
        walletRepositories.saveAll(walletList);

        serviceHistory.saveHistory("transfer",users1.getUsername(),users2.getUsername(),requestTransfer.getTransferMoney());

        return  wallet1;
    }
}
