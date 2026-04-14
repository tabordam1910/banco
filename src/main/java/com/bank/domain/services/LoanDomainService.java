package com.bank.domain.services;

import com.bank.domain.entities.Loan;
import com.bank.domain.entities.Account;
import com.bank.domain.exceptions.BusinessRuleException;

public class LoanDomainService {
    public void approveLoan(Loan loan) {
        if (!"Under Review".equalsIgnoreCase(loan.getLoanStatus())) {
            throw new BusinessRuleException("Only loans under review can be approved.");
        }
        loan.setLoanStatus("Approved");
    }

    public void processDisbursement(Loan loan, Account targetAccount) {
        if (!"Approved".equalsIgnoreCase(loan.getLoanStatus())) {
            throw new BusinessRuleException("Loan must be approved before disbursement.");
        }
        targetAccount.setBalance(targetAccount.getBalance() + loan.getApprovedAmount());
        loan.setLoanStatus("Disbursed");
    }
}