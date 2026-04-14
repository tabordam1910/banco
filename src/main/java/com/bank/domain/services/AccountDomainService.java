package com.bank.domain.services;

import com.bank.domain.entities.Account;
import com.bank.domain.entities.User;
import com.bank.domain.exceptions.BusinessRuleException;

public class AccountDomainService {

    /**
     * Rule: Validate that a user can actually open a new account[cite: 255].
     */
    public void validateUserForNewAccount(User user) {
        if ("Inactive".equalsIgnoreCase(user.getUserStatus()) || "Blocked".equalsIgnoreCase(user.getUserStatus())) {
            throw new BusinessRuleException("Cannot open an account for an inactive or blocked user.");
        }
    }

    /**
     * Rule: Prevent operations on blocked or cancelled accounts.
     */
    public void verifyAccountStatus(Account account) {
        if ("Blocked".equalsIgnoreCase(account.getAccountStatus()) || "Cancelled".equalsIgnoreCase(account.getAccountStatus())) {
            throw new BusinessRuleException("Operation denied: Account is blocked or cancelled.");
        }
    }
}