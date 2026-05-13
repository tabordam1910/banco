package com.bank.domain.entities;

import java.time.LocalDateTime;

public class AuditLog {
    private String logId;
    private String userId;
    private String operationType; // e.g., "TRANSFER", "LOAN_APPROVAL"
    private String affectedProductId; // ID of Account or Loan
    private String detailsJson; // The "Datos_Detalle" mentioned in the PDF
    private LocalDateTime timestamp;

    public AuditLog(String logId, String userId, String operationType, String affectedProductId, String detailsJson) {
        this.logId = logId;
        this.userId = userId;
        this.operationType = operationType;
        this.affectedProductId = affectedProductId;
        this.detailsJson = detailsJson;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public String getLogId() { return logId; }
    public String getUserId() { return userId; }
    public String getOperationType() { return operationType; }
    public String getAffectedProductId() { return affectedProductId; }
    public String getDetailsJson() { return detailsJson; }
    public LocalDateTime getTimestamp() { return timestamp; }
}