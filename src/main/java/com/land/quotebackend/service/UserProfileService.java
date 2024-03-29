package com.land.quotebackend.service;

import com.land.quotebackend.dto.response.userprofile.UserProfileGetAllResponse;
import com.land.quotebackend.entity.Bookmark;
import com.land.quotebackend.entity.UserProfile;

import java.util.List;

public interface UserProfileService {

    List<UserProfile> getAllUserProfiles(int index, int count);
    List<Bookmark> getUsersBookmarks(String id);
    UserProfile getUserProfileById(String id);
    void createUserProfile(UserProfile userProfile);
    void updateUserProfile(UserProfile userProfile);
    void deleteUserProfileById(String id);
}
