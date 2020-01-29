package com.wyncore.mysql.rest.api.exception;

/**
 * This is an exception class for handling API related exceptions.
 */
public class ApiException extends AppException {

  /**
   * This is an exception constructor which takes error message as input.
   *
   * @param errorMessage : error message
   */
  public ApiException(final String errorMessage) {
    super(errorMessage);
  }

  /**
   * This exception constructor takes error message and the throwable cause.
   *
   * @param errorMessage : error message
   * @param cause        : cause for which exception is thrown
   */
  public ApiException(final String errorMessage, final Throwable cause) {
    super(errorMessage, cause);
  }

  /**
   * This is a default constructor.
   */
  public ApiException() {
    super();
  }
}
