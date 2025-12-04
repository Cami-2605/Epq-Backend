package com.epq.epq_backend.exception;

public class badRequestException extends RuntimeException {
    public badRequestException(String message) {
        super(message);
    }
}
