package com.land.quotebackend.excepiton;

import com.land.quotebackend.entity.BaseEntity;

public class BaseException extends RuntimeException {
    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }
}
