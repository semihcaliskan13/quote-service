package com.land.quotebackend.mapper;

import com.land.quotebackend.dto.request.CreatePostRequest;
import com.land.quotebackend.dto.request.UpdatePostRequest;
import com.land.quotebackend.dto.response.PostGetAllResponse;
import com.land.quotebackend.dto.response.PostGetByIdResponse;
import com.land.quotebackend.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostMapper {

    PostMapper INIT = Mappers.getMapper(PostMapper.class);

    Post createPostRequestToPost(CreatePostRequest request);
    Post updatePostRequestToPost(UpdatePostRequest request);

    List<PostGetAllResponse> postsToGetAllResponse(List<Post> posts);
    PostGetByIdResponse postToGetByIdResponse(Post post);


}
