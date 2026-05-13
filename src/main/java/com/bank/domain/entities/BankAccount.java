package com.bank.domain.entities; 

import com.bank.domain.Enums.AccountStatus;
import java.math.BigDecimal;

public class BankAccount {
    private String accountNumber;
    private String holderName;
    private BigDecimal balance;
    private AccountStatus status;

    public BankAccount() {}

    public BankAccount(String accountNumber, String holderName, BigDecimal balance, AccountStatus status) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.status = status;
    }

    // Business Methods
    public void deposit(BigDecimal amount) {
        if (amount != null && amount.compareTo(BigDecimal.ZERO) > 0) {
            this.balance = this.balance.add(amount);
        }
    }

    // Getters y Setters corregidos
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public BigDecimal getBalance() { return balance; }
    public AccountStatus getStatus() { return status; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
}