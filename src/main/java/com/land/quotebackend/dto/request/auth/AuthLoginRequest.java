package com.land.quotebackend.dto.request.auth;

public record AuthLoginRequest(
        String username,
        String password
) {
}
