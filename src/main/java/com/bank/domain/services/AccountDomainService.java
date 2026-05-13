package com.bank.domain.services;

import com.bank.domain.entities.BankAccount;
import com.bank.domain.Enums.AccountStatus;

public class AccountDomainService {

    
    public boolean isTransactionAllowed(BankAccount account) {
        AccountStatus status = account.getStatus();
        return status != AccountStatus.BLOCKED && status != AccountStatus.CANCELLED;
    }

    
    public boolean validateInitialDeposit(double amount) {
        return amount >= 0;
    }
}