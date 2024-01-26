package com.land.quotebackend.dto.response.userprofile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.land.quotebackend.dto.response.bookmark.BookmarkGetAllResponse;
import com.land.quotebackend.dto.response.post.PostGetAllResponse;
import com.land.quotebackend.dto.response.post.PostGetByIdResponse;
import com.land.quotebackend.dto.response.post.PostsInUserProfileGetAllResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class UserProfileGetByIdResponse
{
    private String userId;
    private String description;
    private String imageUrl;
    private Instant createdAt;
    private Instant updatedAt;
    private List<PostGetAllResponse> posts;
    private List<BookmarkGetAllResponse> bookmarks;
}




