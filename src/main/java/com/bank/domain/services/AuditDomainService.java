package com.bank.domain.services;

import java.time.LocalDateTime;

public class AuditDomainService {

    
    public String formatAuditLog(String operation, String result, String metadata) {
        return String.format(
            "{\"operation\": \"%s\", \"timestamp\": \"%s\", \"status\": \"%s\", \"data\": %s}",
            operation, LocalDateTime.now(), result, metadata
        );
    }
}