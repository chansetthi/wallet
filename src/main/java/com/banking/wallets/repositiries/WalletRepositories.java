package com.banking.wallets.repositiries;

import com.banking.wallets.entities.Users;
import com.banking.wallets.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepositories extends JpaRepository<Wallet, Long>{
    Wallet findByUsersFk(Users user);
}
