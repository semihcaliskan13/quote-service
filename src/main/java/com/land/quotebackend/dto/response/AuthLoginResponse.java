package com.land.quotebackend.dto.response;

import lombok.Builder;

public record AuthLoginResponse(
        String token
) {
}
