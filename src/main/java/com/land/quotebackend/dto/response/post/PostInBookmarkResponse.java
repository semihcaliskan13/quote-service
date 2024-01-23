package com.land.quotebackend.dto.response.post;

import java.time.Instant;

public record PostInBookmarkResponse(
        String id,
        String title,
        String content,
        Instant createdAt,
        Instant updatedAt
) {
}
