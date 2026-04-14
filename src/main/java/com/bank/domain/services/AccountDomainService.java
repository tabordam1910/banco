package com.bank.domain.services;

import com.bank.domain.entities.Account;
import com.bank.domain.entities.User;
import com.bank.domain.exceptions.BusinessRuleException;

public class AccountDomainService {
    public void validateNewAccount(User user) {
        if ("Inactive".equalsIgnoreCase(user.getUserStatus()) || "Blocked".equalsIgnoreCase(user.getUserStatus())) {
            throw new BusinessRuleException("Cannot open account for inactive or blocked users.");
        }
    }

    public void checkTransactionEligibility(Account account) {
        if ("Blocked".equalsIgnoreCase(account.getAccountStatus()) || "Cancelled".equalsIgnoreCase(account.getAccountStatus())) {
            throw new BusinessRuleException("Account is not eligible for transactions.");
        }
    }
}