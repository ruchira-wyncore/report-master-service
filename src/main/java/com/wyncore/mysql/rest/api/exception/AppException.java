package com.wyncore.mysql.rest.api.exception;

/**
 * This exception class wraps all checked exceptions and enriches them with the custom code.
 */
public class AppException extends Exception {

  /**
   * This is an exception constructor which takes error message as input.
   *
   * @param errorMessage : Error message.
   */
  public AppException(final String errorMessage) {
    super(errorMessage);
  }

  /**
   * This exception constructor takes error message and the throwable cause.
   *
   * @param errorMessage : error message
   * @param cause        : cause for which exception is thrown
   */
  public AppException(final String errorMessage, final Throwable cause) {
    super(errorMessage, cause);
  }

  /**
   * Default constructor.
   */
  public AppException() {
  }
}
