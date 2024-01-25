package com.land.quotebackend.dto.request.userprofile;

import jakarta.validation.constraints.NotEmpty;

public record UserProfileUpdateRequest(
        @NotEmpty
        String userId,
        String description,
        String imageUrl
) {
}
