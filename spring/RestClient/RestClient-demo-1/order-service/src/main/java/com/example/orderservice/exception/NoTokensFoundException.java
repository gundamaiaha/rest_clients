package com.example.orderservice.exception;

public class NoTokensFoundException extends RuntimeException {

    public NoTokensFoundException(String message) {
        super(message);
    }
}
