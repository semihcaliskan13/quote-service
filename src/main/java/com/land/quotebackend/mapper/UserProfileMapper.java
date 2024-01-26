package com.land.quotebackend.mapper;

import com.land.quotebackend.dto.queryParams.UserProfileGetByIdParams;
import com.land.quotebackend.dto.request.userprofile.UserProfileUpdateRequest;
import com.land.quotebackend.dto.response.post.PostGetAllResponse;
import com.land.quotebackend.dto.response.userprofile.UserProfileGetAllResponse;
import com.land.quotebackend.dto.response.userprofile.UserProfileGetByIdResponse;
import com.land.quotebackend.entity.Post;
import com.land.quotebackend.entity.UserProfile;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserProfileMapper {

    UserProfileMapper INIT = Mappers.getMapper(UserProfileMapper.class);


    List<UserProfileGetAllResponse> USER_PROFILE_GET_ALL_RESPONSES(List<UserProfile> userProfiles);

    UserProfileGetAllResponse USER_PROFILE_GET_ALL_RESPONSE(UserProfile userProfile);


    @Mapping(target = "posts", ignore = true)
    @Mapping(target = "bookmarks", ignore = true)
    UserProfileGetByIdResponse USER_PROFILE_GET_BY_ID_RESPONSE(UserProfile userProfile, @Context UserProfileGetByIdParams params);

    @Mapping(target = "userProfile", ignore = true)
    PostGetAllResponse postToPostGetAllResponse(Post post);

    List<PostGetAllResponse> postToPostGetAllResponseList(List<Post> post);

    @AfterMapping
    default void map(UserProfile source, @MappingTarget UserProfileGetByIdResponse target, @Context UserProfileGetByIdParams params) {
        if (params.include_posts()) {
            target.setPosts((UserProfileMapper.INIT.postToPostGetAllResponseList(source.getPosts())));
        }
        if (params.include_bookmarks()) {
            target.setBookmarks(BookmarkMapper.INIT.BOOKMARK_GET_ALL_RESPONSES(source.getBookmarks()));
        }
    }


    UserProfile USER_PROFILE_UPDATE_REQUEST_USER_PROFILE(UserProfileUpdateRequest request);

}
