package com.land.quotebackend.dto.request;

public record CreatePostRequest(
        String title,
        String content
) {
}
