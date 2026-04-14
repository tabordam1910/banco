package com.bank.domain.entities;

import java.time.LocalDateTime;

public class Loan {
    private int loanId;
    private double approvedAmount;
    private String loanStatus; // Under Review, Approved, Rejected, Disbursed
    private String targetAccountNumber;

    // Getters and Setters
    public String getLoanStatus() { return loanStatus; }
    public void setLoanStatus(String status) { this.loanStatus = status; }
    public double getApprovedAmount() { return approvedAmount; }
    public String getTargetAccountNumber() { return targetAccountNumber; }
}