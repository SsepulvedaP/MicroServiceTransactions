package com.MicroService.MicroServiceTransaction.domain.exception;

public class WrongQuantity extends RuntimeException {
    public WrongQuantity(String message) {
        super(message);
    }
}
