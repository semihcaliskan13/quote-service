package com.land.quotebackend.dto.response.user;

import com.land.quotebackend.dto.response.role.RoleGetAllResponse;
import com.land.quotebackend.dto.response.userprofile.UserProfileGetAllResponse;

import java.time.Instant;
import java.util.List;

public record UserGetByIdResponse(
        String id,
        String username,
        String email,
        Instant createdAt,
        Instant updatedAt,
        UserProfileGetAllResponse userProfile
) {
}
