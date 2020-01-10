package com.banking.wallets.DTO;

public class ResponseAddmoney extends Response{
    private String username;
    private String addmoney;
    private String totalAmount;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddmoney() {
        return addmoney;
    }

    public void setAddmoney(String addmoney) {
        this.addmoney = addmoney;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
