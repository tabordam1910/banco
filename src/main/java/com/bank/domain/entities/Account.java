package com.bank.domain.entities;

public class Account {
    private String accountNumber;
    private String accountType;
    private String ownerId;
    private double balance;
    private String accountStatus; // Active, Blocked, Cancelled

    // Getters and Setters
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public String getAccountStatus() { return accountStatus; }
    public void setAccountStatus(String status) { this.accountStatus = status; }
}