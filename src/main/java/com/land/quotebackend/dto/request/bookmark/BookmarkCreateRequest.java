package com.land.quotebackend.dto.request.bookmark;

public record BookmarkCreateRequest(
        String name,
        String description,
        String userProfileId

) {
}
