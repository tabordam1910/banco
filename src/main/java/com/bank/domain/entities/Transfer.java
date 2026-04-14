package com.bank.domain.entities;

public class Transfer {
    private int transferId;
    private double amount;
    private String transferStatus; // Executed, Pending Approval, Expired

    // Getters and Setters
    public double getAmount() { return amount; }
    public String getTransferStatus() { return transferStatus; }
    public void setTransferStatus(String status) { this.transferStatus = status; }
}