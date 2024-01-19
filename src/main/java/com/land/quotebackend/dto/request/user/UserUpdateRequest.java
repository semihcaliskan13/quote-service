package com.land.quotebackend.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserUpdateRequest(
        @NotEmpty
        String id,
        @NotEmpty
        String username,
        @Email
        String email,
        @Size(min = 8,max = 16, message = "Password must be between 8 and 16 chars!")
        String password
) {
}
