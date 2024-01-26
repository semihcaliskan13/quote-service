package com.land.quotebackend.api.controller;

import com.land.quotebackend.dto.queryParams.UserProfileGetByIdParams;
import com.land.quotebackend.dto.request.userprofile.UserProfileUpdateRequest;
import com.land.quotebackend.dto.response.bookmark.BookmarkGetAllResponse;
import com.land.quotebackend.dto.response.userprofile.UserProfileGetAllResponse;
import com.land.quotebackend.dto.response.userprofile.UserProfileGetByIdResponse;
import com.land.quotebackend.entity.UserProfile;
import com.land.quotebackend.mapper.BookmarkMapper;
import com.land.quotebackend.mapper.UserProfileMapper;
import com.land.quotebackend.service.BookmarkService;
import com.land.quotebackend.service.FileService;
import com.land.quotebackend.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
public class UserProfileController {

    @Value("${cloud.aws.user-profile.bucketname}")
    private String bucketName;

    private final UserProfileService userProfileService;
    private final BookmarkService bookmarkService;
    private final FileService fileService;

    public UserProfileController(UserProfileService userProfileService, BookmarkService bookmarkService, FileService fileService) {
        this.userProfileService = userProfileService;
        this.bookmarkService = bookmarkService;
        this.fileService = fileService;
    }

    @GetMapping
    List<UserProfileGetAllResponse> userProfileGetAllResponses(int index, int count) {
        return UserProfileMapper.INIT.USER_PROFILE_GET_ALL_RESPONSES(userProfileService.getAllUserProfiles(index,count));
    }

    @GetMapping(value = "{id}")
    public UserProfileGetByIdResponse userProfileGetByIdResponse(@PathVariable String id, UserProfileGetByIdParams params){
        return UserProfileMapper.INIT.USER_PROFILE_GET_BY_ID_RESPONSE(userProfileService.getUserProfileById(id), params);
    }

    @GetMapping(value = "{id}/bookmarks")
    public List<BookmarkGetAllResponse> getUsersBookmarks(@PathVariable String id){
        var userProfile = new UserProfile();
        userProfile.setUserId(id);
        return BookmarkMapper.INIT.BOOKMARK_GET_ALL_RESPONSES(bookmarkService.getUserProfilesBookmarks(userProfile));
    }

    @PostMapping(value = "{id}/upload")
    public String uploadUserProfilePhoto(@PathVariable String id, @RequestPart UserProfileUpdateRequest request, MultipartFile file) throws IOException {
        UserProfile userProfile =UserProfileMapper.INIT.USER_PROFILE_UPDATE_REQUEST_USER_PROFILE(request);
        return fileService.fileUpload(bucketName,file,userProfile);
    }

    @PutMapping
    public void updateUserProfile(@RequestBody @Valid UserProfileUpdateRequest request){
        userProfileService.updateUserProfile(UserProfileMapper.INIT.USER_PROFILE_UPDATE_REQUEST_USER_PROFILE(request));
    }

}
