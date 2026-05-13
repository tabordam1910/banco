package com.bank.domain.entities;

import java.math.BigDecimal;

public class BankAccount {
    private String accountNumber;
    private String accountType;
    private String ownerId;
    private BigDecimal balance;
    private String status;

    // This is the constructor the Main.java is looking for
    public BankAccount(String accountNumber, String accountType, String ownerId) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.ownerId = ownerId;
        this.balance = BigDecimal.ZERO; // Initialize with 0
        this.status = "ACTIVE";
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Business Logic Methods
    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }
}