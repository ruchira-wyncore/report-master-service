package com.wyncore.mysql.rest.api.exception;

/**
 * This exception class wraps all checked exceptions and enriches
 * them with the custom code.
 */
public class AppException extends Exception {


    public AppException(String errorMessage) {
        super(errorMessage);
    }

    public AppException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }


    public AppException() {
    }
}
