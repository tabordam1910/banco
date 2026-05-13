package com.bank.domain.entities;

public class Transfer {
    private int transferId;
    private double amount;
    private String transferStatus; // Executed, Pending Approval, Expired

    public Transfer(int transferId, double amount) {
        this.transferId = transferId;
        this.amount = amount;
        this.transferStatus = "Pending Approval";
    }

    // Agregamos este Getter para que desaparezca la advertencia
    public int getTransferId() {
        return transferId;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String status) {
        this.transferStatus = status;
    }
}