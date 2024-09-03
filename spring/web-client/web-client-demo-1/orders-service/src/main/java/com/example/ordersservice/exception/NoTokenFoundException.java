package com.example.ordersservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoTokenFoundException extends RuntimeException {

    public NoTokenFoundException(String message) {
        super(message);
    }
}
