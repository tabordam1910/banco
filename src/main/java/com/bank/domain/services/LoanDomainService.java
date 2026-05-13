package com.bank.domain.services;

import com.bank.domain.entities.BankAccount;
import com.bank.domain.entities.Loan;
import com.bank.domain.Enums.LoanStatus;

public class LoanDomainService {

    public void approveLoan(Loan loan) {
        if (loan.getStatus() == LoanStatus.IN_STUDY) {
            loan.setStatus(LoanStatus.APPROVED);
        }
    }

    public void executeDisbursement(Loan loan, BankAccount account) {
        // Regla: Solo si está aprobado se entrega el dinero
        if (loan.getStatus() == LoanStatus.APPROVED) {
            // Ahora getAmountApproved() ya no marcará error
            account.deposit(loan.getAmountApproved());
            loan.setStatus(LoanStatus.DISBURSED);
        }
    }
}