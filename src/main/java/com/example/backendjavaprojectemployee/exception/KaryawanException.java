package com.example.backendjavaprojectemployee.exception;

public class KaryawanException extends Exception {
    public KaryawanException() {
    }

    public KaryawanException(String message) {
        super(message);
    }

    public KaryawanException(String message, Throwable cause) {
        super(message, cause);
    }

    public KaryawanException(Throwable cause) {
        super(cause);
    }

    public KaryawanException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
