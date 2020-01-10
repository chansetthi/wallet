package com.banking.wallets.repositiries;

import com.banking.wallets.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepositories extends JpaRepository<History,Long> {
    public List<History> findAllByPayer(String username);
}
