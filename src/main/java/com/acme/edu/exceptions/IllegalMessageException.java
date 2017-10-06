package com.acme.edu.exceptions;

public class IllegalMessageException extends RuntimeException {
    public IllegalMessageException() {
        super();
    }

    public IllegalMessageException(String message) {
        super(message);
    }

    public IllegalMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalMessageException(Throwable cause) {
        super(cause);
    }

    protected IllegalMessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
