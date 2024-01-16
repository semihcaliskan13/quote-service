package com.land.quotebackend.dto.request;

public record AuthLoginRequest(
        String username,
        String password
) {
}
