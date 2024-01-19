package com.land.quotebackend.dto.request.role;

import jakarta.validation.constraints.NotEmpty;

public record RoleUpdateRequest(
        @NotEmpty
        String id,
        String role
) {
}
