package com.land.quotebackend.dto.response.userprofile;

public record UserProfileInPostResponse (
        String userId,
        String description,
        String imageUrl
){
}
