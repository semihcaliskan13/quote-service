package com.land.quotebackend.dto.response.bookmark;

import com.land.quotebackend.dto.response.post.PostInBookmarkResponse;

import java.time.Instant;
import java.util.List;

public record BookmarkGetByIdResponse(
        String id,
        String name,
        String description,
        Instant createdAt,
        List<PostInBookmarkResponse> posts
) {
}
