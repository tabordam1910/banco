package com.bank.domain.entities;

import com.bank.domain.Enums.AccountStatus;
import java.math.BigDecimal;

public class Account {
    // Attributes
    private String accountNumber;
    private String accountType;
    private String ownerId;
    private BigDecimal balance;
    private AccountStatus status;

    // Constructor
    public Account(String accountNumber, String accountType, String ownerId) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.ownerId = ownerId;
        this.balance = BigDecimal.ZERO;
        this.status = AccountStatus.ACTIVE;
    }

    // --- GETTERS (This removes the "not used" warnings) ---

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

    public AccountStatus getStatus() {
        return status;
    }

    // --- SETTERS AND MUTATORS ---

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    /**
     * Updates the balance by adding an amount.
     * Used during deposits or loan disbursements.
     */
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            this.balance = this.balance.add(amount);
        }
    }
}