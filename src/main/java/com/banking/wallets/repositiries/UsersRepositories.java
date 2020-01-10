package com.banking.wallets.repositiries;

import com.banking.wallets.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepositories extends JpaRepository<Users, Long> {
    public Users findByUsernameAndPassword(String username, String password);
    public Users findByUsername(String username);
}
