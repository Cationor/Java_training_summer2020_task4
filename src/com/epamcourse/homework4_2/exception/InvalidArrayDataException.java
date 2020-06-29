package com.epamcourse.homework4_2.exception;

public class InvalidArrayDataException extends Exception {
    public InvalidArrayDataException() {
        super();
    }

    public InvalidArrayDataException(String message) {
        super(message);
    }

    public InvalidArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidArrayDataException(Throwable cause) {
        super(cause);
    }
}
