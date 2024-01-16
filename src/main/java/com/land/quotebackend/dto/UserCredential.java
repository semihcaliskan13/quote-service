package com.land.quotebackend.dto;

import com.land.quotebackend.entity.Role;

import java.util.List;

public record UserCredential(
        String id,
        String username,
        String password,
        List<Role> roles
) {
}
