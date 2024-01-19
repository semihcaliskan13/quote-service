package com.land.quotebackend.dto.response.userprofile;

public record UserProfileGetAllResponse(
        String id,
        String description,
        String imageUrl
) {
}
