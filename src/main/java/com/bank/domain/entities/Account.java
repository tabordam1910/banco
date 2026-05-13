package com.bank.domain.entities;

public class Account {
    private String accountNumber;
    private String accountType; 
    private String ownerId;     
    private double balance;
    private String accountStatus;



    
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountStatus(String status) {
        this.accountStatus = status;
    }
}