package com.wyncore.mysql.rest.api.exception;

/**
 * This is an exception class that wraps all database related exceptions.
 */
public class DbException extends AppException {

    public DbException(String errorMessage) {
        super(errorMessage);
    }

    public DbException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }


    public DbException() {
        super();
    }
}
