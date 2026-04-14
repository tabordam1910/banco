package com.bank.domain.services;

import com.bank.domain.entities.Loan;
import com.bank.domain.entities.Account;
import com.bank.domain.exceptions.BusinessRuleException;

public class LoanDomainService {

    public void approveLoan(Loan loan) {
        // Rule: Only loans "Under Review" can be approved [cite: 121]
        if (!"Under Review".equalsIgnoreCase(loan.getLoanStatus())) {
            throw new BusinessRuleException("Only loans under review can be approved.");
        }
        loan.setLoanStatus("Approved");
    }

    public void processDisbursement(Loan loan, Account destinationAccount) {
        // Rule: Disbursement only possible from "Approved" state [cite: 123]
        if (!"Approved".equalsIgnoreCase(loan.getLoanStatus())) {
            throw new BusinessRuleException("Loan must be approved before disbursement.");
        }
        
        // Rule: Target account must be active and increase balance [cite: 82]
        destinationAccount.setBalance(destinationAccount.getBalance() + loan.getApprovedAmount());
        loan.setLoanStatus("Disbursed");
    }
}