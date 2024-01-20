package com.land.quotebackend.dto.request.userprofile;

public record UserProfileUpdateRequest(
        String id,
        String description,
        String imageUrl
) {
}
