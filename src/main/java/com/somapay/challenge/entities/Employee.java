package com.somapay.challenge.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "account_balance", nullable = false, columnDefinition = "float default 0")
    private float accountBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id", nullable = false)
    private Company company;

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

    public Integer getCompanyId(){
        return company.getId();
    }

    public String getCompanyName(){
        return company.getName();
    }

    @JsonIgnore
    public Company getCompany() {
        return company;
    }

    @JsonIgnore
    public void setCompany(Company company) {
        this.company = company;
    }
}
