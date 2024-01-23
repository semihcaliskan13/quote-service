package com.land.quotebackend.dto.response.post;

import com.land.quotebackend.dto.response.userprofile.UserProfileGetByIdResponse;
import com.land.quotebackend.dto.response.userprofile.UserProfileInPostResponse;
import com.land.quotebackend.entity.UserProfile;

import java.time.Instant;

public record PostGetAllResponse(
        String id,
        String title,
        String content,
        Instant createdAt,
        Instant updatedAt,
        UserProfileInPostResponse userProfile
) {
}
