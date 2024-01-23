package com.land.quotebackend.dto.response.userprofile;

import com.land.quotebackend.dto.response.bookmark.BookmarkGetAllResponse;
import com.land.quotebackend.dto.response.post.PostGetByIdResponse;

import java.util.List;

public record UserProfileGetByIdResponse(
        String userId,
        String description,
        String imageUrl,
        List<PostGetByIdResponse> posts,
        List<BookmarkGetAllResponse> bookmarks


) {
}
