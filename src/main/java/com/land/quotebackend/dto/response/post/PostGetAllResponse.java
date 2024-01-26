package com.land.quotebackend.dto.response.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.land.quotebackend.dto.response.userprofile.UserProfileInPostResponse;

import java.time.Instant;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PostGetAllResponse(
        String id,
        String title,
        String content,
        Instant createdAt,
        Instant updatedAt,
        UserProfileInPostResponse userProfile
) {
}
