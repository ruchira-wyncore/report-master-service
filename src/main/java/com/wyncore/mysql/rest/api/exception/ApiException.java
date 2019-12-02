package com.wyncore.mysql.rest.api.exception;

/**
 * This is an exception class for handling API related exceptions.
 */
public class ApiException extends AppException {

    public ApiException(String errorMessage) {
        super(errorMessage);
    }

    public ApiException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }


    public ApiException() {
        super();
    }
}
