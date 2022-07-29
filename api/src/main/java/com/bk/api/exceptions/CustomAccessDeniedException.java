package com.bk.api.exceptions;

public class CustomAccessDeniedException extends RuntimeException {
    public CustomAccessDeniedException() {
    }

    public CustomAccessDeniedException(String message) {
        super(message);
    }

    public CustomAccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomAccessDeniedException(Throwable cause) {
        super(cause);
    }
}
