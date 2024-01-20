package com.land.quotebackend.mapper;

import com.land.quotebackend.dto.response.userprofile.UserProfileGetAllResponse;
import com.land.quotebackend.dto.response.userprofile.UserProfileGetByIdResponse;
import com.land.quotebackend.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserProfileMapper {

    UserProfileMapper INIT = Mappers.getMapper(UserProfileMapper.class);

    List<UserProfileGetAllResponse> USER_PROFILE_GET_ALL_RESPONSES(List<UserProfile> userProfiles);
    UserProfileGetByIdResponse USER_PROFILE_GET_BY_ID_RESPONSE(UserProfile userProfile);

}
