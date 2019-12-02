package com.wyncore.mysql.rest.api.exception;

import org.junit.jupiter.api.Test;

import static com.wyncore.mysql.rest.api.constants.ErrorCode.RESOURCE_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertThrows;


class AppExceptionTest {


    @Test
    public void testAllMethods(){
        assertThrows(AppException.class, () -> {
            throw new AppException(RESOURCE_NOT_FOUND);
        });
        assertThrows(AppException.class, () -> {
            throw new AppException();
        });
        assertThrows(AppException.class, () -> {
            throw new AppException("Dummy Exception", new Throwable());
        });


    }

}