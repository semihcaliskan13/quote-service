package com.land.quotebackend.dto.request.post;

import jakarta.validation.constraints.Size;

public record PostCreateRequest(
        String title,
        @Size(min = 1,max = 600, message = "İçerik 1 ile 600 karakter arasında olmalıdır!")
        String content
) {
}
