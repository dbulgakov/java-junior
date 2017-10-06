package com.acme.edu.exceptions;

public class IllegalMessageException extends RuntimeException {
    public IllegalMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalMessageException(Throwable cause) {
        super(cause);
    }
}
