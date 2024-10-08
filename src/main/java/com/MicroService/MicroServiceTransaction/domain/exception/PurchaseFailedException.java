package com.MicroService.MicroServiceTransaction.domain.exception;

public class PurchaseFailedException extends RuntimeException {
    public PurchaseFailedException(String message) {
        super(message);
    }
}
