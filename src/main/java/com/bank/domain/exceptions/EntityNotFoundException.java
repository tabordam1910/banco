package com.bank.domain.exceptions;

public class EntityNotFoundException extends BusinessRuleException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}