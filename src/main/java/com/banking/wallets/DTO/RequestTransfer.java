package com.banking.wallets.DTO;

public class RequestTransfer {
    private String payer;
    private String receiver;
    private String transferMoney;

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTransferMoney() {
        return transferMoney;
    }

    public void setTransferMoney(String transferMoney) {
        this.transferMoney = transferMoney;
    }
}
