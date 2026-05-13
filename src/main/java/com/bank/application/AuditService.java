package com.bank.application;

import com.bank.domain.entities.AuditLog;
import java.util.UUID;

public class AuditService {
    
    /**
     * Rule: Save a log entry for every transaction.
     * In a real app, this would save to MongoDB.
     */
    public void recordAction(String userId, String op, String status, String jsonDetails) {
        AuditLog log = new AuditLog(
            UUID.randomUUID().toString(),
            userId,
            op,
            status,
            jsonDetails
        );
        
        // Simulación de guardado en NoSQL
        System.out.println("LOG SAVED TO NOSQL: " + log.getDetailData());
    }
}