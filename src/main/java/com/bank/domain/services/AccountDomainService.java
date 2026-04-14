package com.bank.domain.services;

import com.bank.domain.entities.Account;
import com.bank.domain.entities.User;
import com.bank.domain.exceptions.BusinessRuleException;

public class AccountDomainService {

    public void validateAccountOpening(User user) {
        // Rule: Cannot open account if user is Inactive or Blocked [cite: 116]
        if ("Inactive".equalsIgnoreCase(user.getUserStatus()) || "Blocked".equalsIgnoreCase(user.getUserStatus())) {
            throw new BusinessRuleException("Cannot open account for inactive or blocked users.");
        }
    }

    public void verifyAccountOperational(Account account) {
        // Rule: No operations allowed on Blocked or Cancelled accounts [cite: 119]
        if ("Blocked".equalsIgnoreCase(account.getAccountStatus()) || "Cancelled".equalsIgnoreCase(account.getAccountStatus())) {
            throw new BusinessRuleException("Account is not active for transactions.");
        }
    }
}