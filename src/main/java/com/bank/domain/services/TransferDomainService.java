package com.bank.domain.services;

import com.bank.domain.entities.Transfer;
import com.bank.domain.entities.Account;
import com.bank.domain.exceptions.BusinessRuleException;

public class TransferDomainService {

    private static final double CORPORATE_LIMIT = 10000.0; // Business Rule Threshold [cite: 85]

    public void initiateTransfer(Transfer transfer, Account source) {
        // Rule: If amount exceeds threshold, set to "Pending Approval" [cite: 87]
        if (transfer.getAmount() > CORPORATE_LIMIT) {
            transfer.setTransferStatus("Pending Approval");
        } else {
            executeFundsMovement(transfer, source, null);
        }
    }

    public void executeFundsMovement(Transfer transfer, Account source, Account destination) {
        // Rule: Validate sufficient balance [cite: 91]
        if (source.getBalance() < transfer.getAmount()) {
            throw new BusinessRuleException("Insufficient funds.");
        }

        // Rule: Update balances [cite: 124, 125]
        source.setBalance(source.getBalance() - transfer.getAmount());
        if (destination != null) {
            destination.setBalance(destination.getBalance() + transfer.getAmount());
        }
        transfer.setTransferStatus("Executed");
    }
}