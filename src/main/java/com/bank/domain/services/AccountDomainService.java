package com.bank.domain.services;

import com.bank.domain.entities.Account;
import com.bank.domain.Enums.AccountStatus;

public class AccountDomainService {

    public void blockAccount(Account account) {
        // This will now work because both are AccountStatus type
        account.setStatus(AccountStatus.BLOCKED);
    }

    public void activateAccount(Account account) {
        account.setStatus(AccountStatus.ACTIVE);
    }
}