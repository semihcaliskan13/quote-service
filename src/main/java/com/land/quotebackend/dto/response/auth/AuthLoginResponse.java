package com.land.quotebackend.dto.response.auth;

import lombok.Builder;

public record AuthLoginResponse(
        String token
) {
}
