package com.bank.domain.services;

import com.bank.domain.entities.Transfer;
import com.bank.domain.entities.Account;
import com.bank.domain.exceptions.BusinessRuleException;

public class TransferDomainService {

    // Defined Business Rule Threshold [cite: 175, 224]
    private static final double CORPORATE_APPROVAL_THRESHOLD = 10000.0; 

    /**
     * Rule: Check if transfer requires manual approval based on amount[cite: 226].
     */
    public void initiateTransfer(Transfer transfer, Account sourceAccount) {
        if (transfer.getAmount() > CORPORATE_APPROVAL_THRESHOLD) {
            transfer.setTransferStatus("Pending Approval");
        } else {
            transfer.setTransferStatus("Executed");
        }
    }

    /**
     * Rule: Execute the actual movement of funds[cite: 232, 263].
     */
    public void commitTransfer(Transfer transfer, Account source, Account destination) {
        if (source.getBalance() < transfer.getAmount()) {
            throw new BusinessRuleException("Insufficient funds in source account.");
        }

        source.setBalance(source.getBalance() - transfer.getAmount());
        
        if (destination != null) {
            destination.setBalance(destination.getBalance() + transfer.getAmount());
        }
        
        transfer.setTransferStatus("Executed");
    }
}