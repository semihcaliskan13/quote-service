package com.land.quotebackend.dto.response.userprofile;

public record UserProfileGetByIdResponse(
        String userId,
        String description,
        String imageUrl
) {
}
