package com.land.quotebackend.mapper;

import com.land.quotebackend.dto.request.user.UserCreateRequest;
import com.land.quotebackend.dto.request.user.UserUpdateRequest;
import com.land.quotebackend.dto.response.user.UserGetAllResponse;
import com.land.quotebackend.dto.response.user.UserGetByIdResponse;
import com.land.quotebackend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INIT = Mappers.getMapper(UserMapper.class);

    UserGetByIdResponse userToGetByIdResponse(User user);
    List<UserGetAllResponse> userToGetAllResponse(List<User> users);
    User userCreateRequestToUser(UserCreateRequest request);
    User userUpdateRequestToUser(UserUpdateRequest request);
}
