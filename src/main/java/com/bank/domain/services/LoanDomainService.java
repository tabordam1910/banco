package com.bank.domain.services;

import com.bank.domain.entities.BankAccount; // Importación corregida
import com.bank.domain.entities.Loan;
import com.bank.domain.Enums.LoanStatus;

public class LoanDomainService {

    /**
     * Rule: A loan can only be approved if it is currently "IN_STUDY"[cite: 217, 260].
     */
    public void approveLoan(Loan loan) {
        if (loan.getStatus() == LoanStatus.IN_STUDY) {
            loan.setStatus(LoanStatus.APPROVED);
        }
    }

    /**
     * Rule: Disbursement increases account balance and updates status[cite: 221, 262].
     */
    public void executeDisbursement(Loan loan, BankAccount account) {
        if (loan.getStatus() == LoanStatus.APPROVED) {
            account.deposit(loan.getAmountApproved());
            loan.setStatus(LoanStatus.DISBURSED);
        }
    }
}