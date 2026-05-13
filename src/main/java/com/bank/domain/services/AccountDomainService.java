package com.bank.domain.services;

import com.bank.domain.entities.BankAccount;
import com.bank.domain.Enums.AccountStatus;

public class AccountDomainService {

    /**
     * Rule: Checks if a transaction is allowed based on account status.
     * Blocked or Cancelled accounts cannot perform operations.
     */
    public boolean isTransactionAllowed(BankAccount account) {
        AccountStatus status = account.getStatus();
        return status != AccountStatus.BLOCKED && status != AccountStatus.CANCELLED;
    }

    /**
     * Rule: Validates if the initial deposit meets the minimum requirement.
     */
    public boolean validateInitialDeposit(double amount) {
        return amount >= 0;
    }
}