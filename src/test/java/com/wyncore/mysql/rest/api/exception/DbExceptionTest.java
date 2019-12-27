package com.wyncore.mysql.rest.api.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DbExceptionTest {

    @Test
    public void testAllMethods() {
        assertThrows(DbException.class, () -> {
            throw new DbException(HttpStatus.NOT_FOUND.toString());
        });
        assertThrows(DbException.class, () -> {
            throw new DbException();
        });
        assertThrows(AppException.class, () -> {
            throw new DbException("Dummy Exception", new Throwable());
        });
    }

    }