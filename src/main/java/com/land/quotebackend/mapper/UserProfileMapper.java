package com.land.quotebackend.mapper;

import com.land.quotebackend.api.controller.Params2;
import com.land.quotebackend.dto.request.userprofile.UserProfileUpdateRequest;
import com.land.quotebackend.dto.response.post.PostGetAllResponse;
import com.land.quotebackend.dto.response.userprofile.UserProfileGetAllResponse;
import com.land.quotebackend.dto.response.userprofile.UserProfileGetByIdResponse;
import com.land.quotebackend.entity.Post;
import com.land.quotebackend.entity.UserProfile;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface UserProfileMapper {

    UserProfileMapper INIT = Mappers.getMapper(UserProfileMapper.class);


    List<UserProfileGetAllResponse> USER_PROFILE_GET_ALL_RESPONSES(List<UserProfile> userProfiles);

    UserProfileGetAllResponse USER_PROFILE_GET_ALL_RESPONSE(UserProfile userProfile);


    @Mapping(target = "posts", ignore = true)
    UserProfileGetByIdResponse USER_PROFILE_GET_BY_ID_RESPONSE(UserProfile userProfile, @Context Params2 params2);

    @Mapping(target = "userProfile", ignore = true)
    PostGetAllResponse postToPostGetAllResponse(Post post);
    List<PostGetAllResponse> postToPostGetAllResponseList(List<Post> post);

    @BeforeMapping
    default UserProfileGetByIdResponse map(UserProfile source, @MappingTarget UserProfileGetByIdResponse target, @Context Params2 params2) {
        UserProfileGetByIdResponse record = null;
        if (params2.include_bookmarks()) {
            record = new UserProfileGetByIdResponse(target.userId(), target.description(), target.imageUrl(), UserProfileMapper.INIT.postToPostGetAllResponseList(source.getPosts()), target.bookmarks());
        }
        return record;
    }


    UserProfile USER_PROFILE_UPDATE_REQUEST_USER_PROFILE(UserProfileUpdateRequest request);

}
