package com.wyncore.mysql.rest.api.exception;

import org.junit.jupiter.api.Test;

import static com.wyncore.mysql.rest.api.constants.ErrorCode.RESOURCE_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DbExceptionTest {

    @Test
    public void testAllMethods() {
        assertThrows(DbException.class, () -> {
            throw new DbException(RESOURCE_NOT_FOUND);
        });
        assertThrows(DbException.class, () -> {
            throw new DbException();
        });
        assertThrows(AppException.class, () -> {
            throw new DbException("Dummy Exception", new Throwable());
        });
    }

    }