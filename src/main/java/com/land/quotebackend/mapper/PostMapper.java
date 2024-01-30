package com.land.quotebackend.mapper;

import com.land.quotebackend.dto.request.post.PostCreateRequest;
import com.land.quotebackend.dto.request.post.PostUpdateRequest;
import com.land.quotebackend.dto.response.post.PostGetAllResponse;
import com.land.quotebackend.dto.response.post.PostGetByIdResponse;
import com.land.quotebackend.dto.response.post.PostsInUserProfileGetAllResponse;
import com.land.quotebackend.entity.Post;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostMapper {

    PostMapper INIT = Mappers.getMapper(PostMapper.class);

    Post createPostRequestToPost(PostCreateRequest request);
    Post updatePostRequestToPost(PostUpdateRequest request);

    List<PostGetAllResponse> postsToGetAllResponse(List<Post> posts);
    PostGetByIdResponse postToGetByIdResponse(Post post);

    List<PostsInUserProfileGetAllResponse> postToPostInUserGetAllResponse(List<Post> post);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void postToPostForPartialUpdate(Post dto, @MappingTarget Post entity);

}
