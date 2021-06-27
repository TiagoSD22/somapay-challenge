package com.somapay.challenge.entities;

import javax.persistence.*;

@Entity
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "account_balance", nullable = false, columnDefinition = "float default 0")
    private float accountBalance;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }
}
