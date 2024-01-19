package com.land.quotebackend.dto.response.user;

import com.land.quotebackend.dto.response.role.RoleGetAllResponse;
import com.land.quotebackend.dto.response.userprofile.UserProfileGetAllResponse;

import java.util.List;

public record UserGetAllResponse(
        String id,
        String username,
        String email,
        UserProfileGetAllResponse userProfile,
        List<RoleGetAllResponse> roles
) {
}
