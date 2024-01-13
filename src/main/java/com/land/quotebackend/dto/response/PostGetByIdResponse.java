package com.land.quotebackend.dto.response;

import java.time.Instant;

public record PostGetByIdResponse(
        String id,
        String title,
        String content,
        Instant createdAt,
        Instant updatedAt
) {
}
