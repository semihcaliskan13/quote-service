package com.land.quotebackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;

public record UpdatePostRequest(
        @NotEmpty
        String id,
        String title,
        String content,
        Instant createdAt,
        Instant updatedAt
) {
}
