package com.wyncore.mysql.rest.api.exception;


import org.junit.jupiter.api.Test;

import static com.wyncore.mysql.rest.api.constants.ErrorCode.RESOURCE_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApiExceptionTest {

    @Test
    public void testAllMethods() {
        assertThrows(ApiException.class, () -> {
            throw new ApiException(RESOURCE_NOT_FOUND);
        });
        assertThrows(ApiException.class, () -> {
            throw new ApiException();
        });
        assertThrows(ApiException.class, () -> {
            throw new ApiException("Dummy Exception", new Throwable());
        });

    }
}