package com.bank.domain.services;

import com.bank.domain.entities.Loan;
import com.bank.domain.entities.Account;
import com.bank.domain.exceptions.BusinessRuleException;

public class LoanDomainService {

    /**
     * Rule: Only loans in 'Under Review' status can be approved[cite: 217, 260].
     */
    public void approveLoan(Loan loan) {
        if (!"Under Review".equalsIgnoreCase(loan.getLoanStatus())) {
            throw new BusinessRuleException("Only loans under review can be approved.");
        }
        loan.setLoanStatus("Approved");
    }

    /**
     * Rule: Execute disbursement only if approved and update account balance[cite: 220, 221].
     */
    public void processDisbursement(Loan loan, Account destinationAccount) {
        if (!"Approved".equalsIgnoreCase(loan.getLoanStatus())) {
            throw new BusinessRuleException("Loan must be in 'Approved' status to proceed with disbursement.");
        }

        if (!"Active".equalsIgnoreCase(destinationAccount.getAccountStatus())) {
            throw new BusinessRuleException("Target account for disbursement is not active.");
        }

        // Financial Impact: Increase destination balance [cite: 221]
        destinationAccount.setBalance(destinationAccount.getBalance() + loan.getApprovedAmount());
        loan.setLoanStatus("Disbursed");
    }
}