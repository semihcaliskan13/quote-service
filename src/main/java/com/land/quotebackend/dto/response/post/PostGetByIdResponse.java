package com.land.quotebackend.dto.response.post;

import com.land.quotebackend.dto.response.userprofile.UserProfileInPostResponse;

import java.time.Instant;

public record PostGetByIdResponse(
        String id,
        String title,
        String content,
        Instant createdAt,
        Instant updatedAt,
        UserProfileInPostResponse userProfile
) {
}
