package com.wyncore.mysql.rest.api.exception;


import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ApiExceptionTest {

  @Test
  public void testAllMethods() {
    assertThrows(ApiException.class, () -> {
      throw new ApiException(HttpStatus.NOT_FOUND.toString());
    });
    assertThrows(ApiException.class, () -> {
      throw new ApiException();
    });
    assertThrows(ApiException.class, () -> {
      throw new ApiException("Dummy Exception", new Throwable());
    });

  }
}