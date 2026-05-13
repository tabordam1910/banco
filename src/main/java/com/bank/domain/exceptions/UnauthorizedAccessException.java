package com.bank.domain.exceptions;

public class UnauthorizedAccessException extends BusinessRuleException {
    public UnauthorizedAccessException(String message) {
        super(message);
    }
}