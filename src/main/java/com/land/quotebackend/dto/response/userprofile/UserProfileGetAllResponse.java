package com.land.quotebackend.dto.response.userprofile;

public record UserProfileGetAllResponse(
        String userId,
        String description,
        String imageUrl
) {
}
