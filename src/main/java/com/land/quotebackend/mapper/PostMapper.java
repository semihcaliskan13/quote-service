package com.land.quotebackend.mapper;

import com.land.quotebackend.dto.request.PostCreateRequest;
import com.land.quotebackend.dto.request.PostUpdateRequest;
import com.land.quotebackend.dto.response.PostGetAllResponse;
import com.land.quotebackend.dto.response.PostGetByIdResponse;
import com.land.quotebackend.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostMapper {

    PostMapper INIT = Mappers.getMapper(PostMapper.class);

    Post createPostRequestToPost(PostCreateRequest request);
    Post updatePostRequestToPost(PostUpdateRequest request);

    List<PostGetAllResponse> postsToGetAllResponse(List<Post> posts);
    PostGetByIdResponse postToGetByIdResponse(Post post);


}
