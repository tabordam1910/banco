package com.bank.domain.entities;

import com.bank.domain.Enums.LoanStatus;
import java.math.BigDecimal;

public class Loan {
    private String loanId;
    private BigDecimal amountApproved;
    private LoanStatus status;

    public Loan(String loanId, BigDecimal amountApproved) {
        this.loanId = loanId;
        this.amountApproved = amountApproved;
        this.status = LoanStatus.IN_STUDY;
    }

   
    public String getLoanId() {
        return loanId;
    }

    public BigDecimal getAmountApproved() {
        return amountApproved;
    }

    public void setAmountApproved(BigDecimal amountApproved) {
        this.amountApproved = amountApproved;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }
}