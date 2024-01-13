package com.land.quotebackend.dto.request;

import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;

public record PostUpdateRequest(
        @NotEmpty
        String id,
        String title,
        String content,
        Instant createdAt,
        Instant updatedAt
) {
}
