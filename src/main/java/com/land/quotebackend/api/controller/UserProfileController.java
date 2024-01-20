package com.land.quotebackend.api.controller;

import com.land.quotebackend.dto.response.userprofile.UserProfileGetAllResponse;
import com.land.quotebackend.dto.response.userprofile.UserProfileGetByIdResponse;
import com.land.quotebackend.mapper.UserProfileMapper;
import com.land.quotebackend.service.UserProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    List<UserProfileGetAllResponse> userProfileGetAllResponses() {
        return UserProfileMapper.INIT.USER_PROFILE_GET_ALL_RESPONSES(userProfileService.getAllUserProfiles());
    }

    @GetMapping(value = "{id}")
    public UserProfileGetByIdResponse userProfileGetByIdResponse(@PathVariable String id){
        return UserProfileMapper.INIT.USER_PROFILE_GET_BY_ID_RESPONSE(userProfileService.getUserProfileById(id));
    }

}
