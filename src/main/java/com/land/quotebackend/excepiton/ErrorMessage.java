package com.land.quotebackend.excepiton;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public record ErrorMessage(
        HttpStatus status,
        Instant date,
        String message,
        String path
) {
}
