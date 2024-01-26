package com.land.quotebackend.dto.response.post;

import java.time.Instant;

public record PostsInUserProfileGetAllResponse(
        String id,
        String title,
        String content,
        Instant createdAt,
        Instant updatedAt
) {
}
