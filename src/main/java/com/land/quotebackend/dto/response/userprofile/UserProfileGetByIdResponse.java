package com.land.quotebackend.dto.response.userprofile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.land.quotebackend.dto.response.bookmark.BookmarkGetAllResponse;
import com.land.quotebackend.dto.response.post.PostGetAllResponse;
import com.land.quotebackend.dto.response.post.PostGetByIdResponse;
import com.land.quotebackend.dto.response.post.PostsInUserProfileGetAllResponse;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserProfileGetByIdResponse(
        String userId,
        String description,
        String imageUrl,
        List<PostGetAllResponse> posts,
        List<BookmarkGetAllResponse> bookmarks


) {
}
