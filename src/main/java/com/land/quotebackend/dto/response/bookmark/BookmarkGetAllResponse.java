package com.land.quotebackend.dto.response.bookmark;

import java.time.Instant;

public record BookmarkGetAllResponse(
        String id,
        String name,
        String description,
        Instant createdAt
) {

}
