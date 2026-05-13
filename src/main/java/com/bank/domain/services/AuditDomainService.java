package com.bank.domain.services;

import java.time.LocalDateTime;

public class AuditDomainService {

    /**
     * Rule: Generates the JSON-style detail required for the NoSQL audit log.
     */
    public String formatAuditLog(String operation, String result, String metadata) {
        return String.format(
            "{\"operation\": \"%s\", \"timestamp\": \"%s\", \"status\": \"%s\", \"data\": %s}",
            operation, LocalDateTime.now(), result, metadata
        );
    }
}