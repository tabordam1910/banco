package com.bank.domain.services;

import com.bank.domain.entities.BankAccount;
import com.bank.domain.entities.Transfer;
import com.bank.domain.exceptions.InsufficientBalanceException;
import com.bank.application.AuditService;
import java.math.BigDecimal;


public class TransferDomainService {

    private final AuditService auditService = new AuditService();
    private static final BigDecimal CORPORATE_LIMIT = new BigDecimal("10000");

   
    public void processTransfer(BankAccount source, BankAccount destination, BigDecimal amount, String userId) {
        try {
            
            if (source.getBalance().compareTo(amount) < 0) {
                throw new InsufficientBalanceException("Transfer failed: Insufficient funds in account " + source.getAccountNumber());
            }

      
            source.setBalance(source.getBalance().subtract(amount));
            destination.setBalance(destination.getBalance().add(amount));

            
            String details = String.format(
                "{\"from\": \"%s\", \"to\": \"%s\", \"amount\": %s, \"status\": \"COMPLETED\"}",
                source.getAccountNumber(), 
                destination.getAccountNumber(), 
                amount.toString()
            );

         
            auditService.recordAction(userId, "TRANSFER_EXECUTION", "SUCCESS", details);

        } catch (InsufficientBalanceException e) {
            // Registrar fallo en Bitácora ante error de negocio
            String errorDetails = String.format(
                "{\"error\": \"%s\", \"attempted_amount\": %s}", 
                e.getMessage(), 
                amount.toString()
            );
            auditService.recordAction(userId, "TRANSFER_EXECUTION", "FAILED", errorDetails);
            
       
            throw e;
        }
    }

    
    public boolean requiresManualApproval(BigDecimal amount, String accountType) {
        return accountType.equalsIgnoreCase("CORPORATE") && amount.compareTo(CORPORATE_LIMIT) > 0;
    }

    
    public void rejectTransfer(Transfer transfer, String adminId, String reason) {
        transfer.setTransferStatus("REJECTED");
        String details = String.format("{\"transferId\": %d, \"reason\": \"%s\"}", transfer.getTransferId(), reason);
        auditService.recordAction(adminId, "TRANSFER_REJECTION", "SUCCESS", details);
    }
}