package com.land.quotebackend.dto.queryParams;

public record UserProfileGetByIdParams(
        boolean include_bookmarks,
        boolean include_posts
) {

}
