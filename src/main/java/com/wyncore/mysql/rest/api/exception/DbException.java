package com.wyncore.mysql.rest.api.exception;

/**
 * This is an exception class that wraps all database related exceptions.
 */
public class DbException extends AppException {

  /**
   * This is an exception constructor which takes error message as input.
   *
   * @param errorMessage : Error messagef
   */
  public DbException(final String errorMessage) {
    super(errorMessage);
  }

  /**
   * This exception constructor takes error message and the throwable cause.
   *
   * @param errorMessage : error message
   * @param cause        : cause for which exception is thrown
   */
  public DbException(final String errorMessage, final Throwable cause) {
    super(errorMessage, cause);
  }

  /**
   * Default constructor.
   */
  public DbException() {
    super();
  }
}
