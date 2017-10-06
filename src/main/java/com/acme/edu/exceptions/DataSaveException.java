package com.acme.edu.exceptions;

public class DataSaveException extends Exception {
    public DataSaveException() {
        super();
    }

    public DataSaveException(String message) {
        super(message);
    }

    public DataSaveException(String message, Throwable cause) {
        super(message, cause);
    }

    protected DataSaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
