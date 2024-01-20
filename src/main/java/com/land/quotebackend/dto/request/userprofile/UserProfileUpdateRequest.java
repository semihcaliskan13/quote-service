package com.land.quotebackend.dto.request.userprofile;

public record UserProfileUpdateRequest(
        String userId,
        String description,
        String imageUrl
) {
}
