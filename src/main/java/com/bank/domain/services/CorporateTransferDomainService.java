package com.bank.domain.services;

import com.bank.domain.Enums.TransferStatus;
import java.math.BigDecimal;

public class CorporateTransferDomainService {
    
    private static final BigDecimal MAX_UNATTENDED_AMOUNT = new BigDecimal("10000");

    
    public TransferStatus validateTransfer(BigDecimal amount, boolean isCorporate) {
        if (isCorporate && amount.compareTo(MAX_UNATTENDED_AMOUNT) > 0) {
            return TransferStatus.PENDING_APPROVAL;
        }
        return TransferStatus.COMPLETED;
    }
}