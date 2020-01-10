package com.banking.wallets.database;

import com.banking.wallets.entities.History;
import com.banking.wallets.repositiries.HistoryRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class ServiceHistory {
    @Autowired
    HistoryRepositories historyRepositories;

    Logger logger = LoggerFactory.getLogger(ServiceHistory.class);

    public void saveHistory(String action,String player,String receiver,String money){
        logger.info("Start Service SaveHistory");
        Date date = new Date();
        History history = new History();
        history.setDate(date);
        history.setAction(action);
        history.setPayer(player);
        history.setRecelver(receiver);
        history.setMoney(money);
        historyRepositories.save(history);
        logger.info("End Service SaveHistory");

    }
}
