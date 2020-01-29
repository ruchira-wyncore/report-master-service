package com.wyncore.mysql.rest.api.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;


class AppExceptionTest {


  @Test
  public void testAllMethods() {
    assertThrows(AppException.class, () -> {
      throw new AppException(HttpStatus.NOT_FOUND.toString());
    });
    assertThrows(AppException.class, () -> {
      throw new AppException();
    });
    assertThrows(AppException.class, () -> {
      throw new AppException("Dummy Exception", new Throwable());
    });


  }

}