package com.MicroService.MicroServiceTransaction.infrastructure.exception;

public class FeignConectionError extends RuntimeException {
    public FeignConectionError(String message) {
        super(message);
    }
}
