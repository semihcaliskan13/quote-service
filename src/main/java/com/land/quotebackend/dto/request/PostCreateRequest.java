package com.land.quotebackend.dto.request;

public record PostCreateRequest(
        String title,
        String content
) {
}
