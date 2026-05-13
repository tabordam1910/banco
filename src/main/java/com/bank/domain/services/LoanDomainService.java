package com.bank.domain.services;

import com.bank.domain.entities.Loan;
import com.bank.domain.entities.BankAccount;
import com.bank.domain.Enums.LoanStatus;
import com.bank.domain.exceptions.UnauthorizedAccessException;
import com.bank.application.AuditService;
import java.math.BigDecimal;

public class LoanDomainService {
    private final AuditService auditService = new AuditService();

    /**
     * Rule: Only an Internal Analyst can approve a loan.
     */
    public void approveLoan(Loan loan, String adminId) {
        if (loan.getStatus() != LoanStatus.IN_STUDY) {
            throw new IllegalStateException("Only loans in 'IN_STUDY' status can be approved.");
        }
        loan.setStatus(LoanStatus.APPROVED);
        
        String details = String.format("{\"loanId\": \"%s\", \"action\": \"APPROVE\"}", loan.getLoanId());
        auditService.recordAction(adminId, "LOAN_APPROVAL", "SUCCESS", details);
    }

    /**
     * Rule: Reject a loan application.
     */
    public void rejectLoan(Loan loan, String adminId) {
        loan.setStatus(LoanStatus.REJECTED);
        
        String details = String.format("{\"loanId\": \"%s\", \"action\": \"REJECT\"}", loan.getLoanId());
        auditService.recordAction(adminId, "LOAN_REJECTION", "SUCCESS", details);
    }

    /**
     * Rule: Disbursement increases account balance.
     * Must be in APPROVED status first.
     */
    public void executeDisbursement(Loan loan, BankAccount account, String adminId) {
        if (loan.getStatus() != LoanStatus.APPROVED) {
            throw new UnauthorizedAccessException("Cannot disburse: Loan is not approved.");
        }

        // Logic: Add loan amount to account balance
        BigDecimal amount = loan.getAmountApproved();
        account.setBalance(account.getBalance().add(amount));
        loan.setStatus(LoanStatus.DISBURSED);

        String details = String.format("{\"loanId\": \"%s\", \"disbursedTo\": \"%s\", \"amount\": %s}", 
                        loan.getLoanId(), account.getAccountNumber(), amount.toString());
        auditService.recordAction(adminId, "LOAN_DISBURSEMENT", "SUCCESS", details);
    }
}