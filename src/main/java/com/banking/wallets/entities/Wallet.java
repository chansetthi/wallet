package com.banking.wallets.entities;

import javax.persistence.*;

@Entity
@Table(name = "Wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String money;
    @ManyToOne
    @JoinColumn(name="UserFk")
    private Users usersFk;

    public Users getUsersFk() {
        return usersFk;
    }

    public void setUsersFk(Users usersFk) {
        this.usersFk = usersFk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
