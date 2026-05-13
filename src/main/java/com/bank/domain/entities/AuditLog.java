package com.bank.domain.entities;

import java.time.LocalDateTime;

public class AuditLog {
    private String logId;
    private String userId;
    private String operation;
    private String status;
    private String detailData; // El JSON de "Datos_Detalle"
    private LocalDateTime timestamp;

    public AuditLog(String logId, String userId, String operation, String status, String detailData) {
        this.logId = logId;
        this.userId = userId;
        this.operation = operation;
        this.status = status;
        this.detailData = detailData;
        this.timestamp = LocalDateTime.now();
    }

    // El método que te faltaba:
    public String getDetailData() {
        return detailData;
    }

    // Otros Getters necesarios para que no te den warnings
    public String getLogId() { return logId; }
    public String getUserId() { return userId; }
    public String getOperation() { return operation; }
    public String getStatus() { return status; }
    public LocalDateTime getTimestamp() { return timestamp; }
}