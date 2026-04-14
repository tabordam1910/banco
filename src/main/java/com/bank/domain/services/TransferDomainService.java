package com.bank.domain.services;

import com.bank.domain.entities.Transfer;
import com.bank.domain.entities.Account;
import com.bank.domain.exceptions.BusinessRuleException;

public class TransferDomainService {
    private static final double CORPORATE_THRESHOLD = 10000.0;

    public void processTransfer(Transfer transfer, Account source, Account destination) {
        if (transfer.getAmount() > CORPORATE_THRESHOLD) {
            transfer.setTransferStatus("Pending Approval");
            return;
        }
        executeMovement(transfer, source, destination);
    }

    public void executeMovement(Transfer transfer, Account source, Account destination) {
        if (source.getBalance() < transfer.getAmount()) {
            throw new BusinessRuleException("Insufficient funds.");
        }
        source.setBalance(source.getBalance() - transfer.getAmount());
        if (destination != null) {
            destination.setBalance(destination.getBalance() + transfer.getAmount());
        }
        transfer.setTransferStatus("Executed");
    }
}