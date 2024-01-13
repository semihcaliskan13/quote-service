package com.land.quotebackend.dto.response;

import java.time.Instant;

public record PostGetAllResponse(
        String id,
        String title,
        String content,
        Instant createdAt,
        Instant updatedAt
) {
}
