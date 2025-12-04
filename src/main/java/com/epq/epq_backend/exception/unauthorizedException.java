package com.epq.epq_backend.exception;

public class unauthorizedException extends RuntimeException {
    public unauthorizedException(String message) {
        super(message);
    }
}
