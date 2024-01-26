package com.land.quotebackend.dto.response.userprofile;

import java.time.Instant;

public record UserProfileInPostResponse (
        String userId,
        String description,
        String imageUrl,
        Instant createdAt,
        Instant updatedAt
){
}
