package com.banking.wallets.DTO;

public class ResponseWithdrawMoney extends Response {
    private String username;
    private String withdrawMoney;
    private String totalAmont;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWithdrawMoney() {
        return withdrawMoney;
    }

    public void setWithdrawMoney(String withdrawMoney) {
        this.withdrawMoney = withdrawMoney;
    }

    public String getTotalAmont() {
        return totalAmont;
    }

    public void setTotalAmont(String totalAmont) {
        this.totalAmont = totalAmont;
    }
}
