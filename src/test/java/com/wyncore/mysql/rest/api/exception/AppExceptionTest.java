package com.wyncore.mysql.rest.api.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertThrows;


class AppExceptionTest {


    @Test
    public void testAllMethods(){
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