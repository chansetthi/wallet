package com.banking.wallets.DTO;

import java.util.List;

public class ResponseHistory extends Response{
    private String startDate;
    private String endDate;
    private String totalAmount;
    private List<ResponseListHistory> history;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<ResponseListHistory> getHistory() {
        return history;
    }

    public void setHistory(List<ResponseListHistory> history) {
        this.history = history;
    }
}
