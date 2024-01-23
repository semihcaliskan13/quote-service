package com.land.quotebackend.api.controller;

import com.land.quotebackend.dto.request.bookmark.BookmarkCreateRequest;
import com.land.quotebackend.dto.response.bookmark.BookmarkGetAllResponse;
import com.land.quotebackend.dto.response.bookmark.BookmarkGetByIdResponse;
import com.land.quotebackend.entity.UserProfile;
import com.land.quotebackend.mapper.BookmarkMapper;
import com.land.quotebackend.service.BookmarkService;
import com.land.quotebackend.service.UserProfileService;
import org.mapstruct.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookmarks")
public class BookmarkController {
    //user can create a bookmark
    //user can add post a specific bookmark
    //user can delete a post in a bookmark
    //user can see all bookmarks
    //user can see specific bookmark and its posts
    //user can delete a bookmark
    private final UserProfileService userProfileService;

    private final BookmarkService bookmarkService;

    public BookmarkController(UserProfileService userProfileService, BookmarkService bookmarkService) {
        this.userProfileService = userProfileService;
        this.bookmarkService = bookmarkService;
    }

    @GetMapping
    public List<BookmarkGetAllResponse> getAllBookmarks(@RequestParam int index, @RequestParam int count) {
        return BookmarkMapper.INIT.BOOKMARK_GET_ALL_RESPONSES(bookmarkService.getAll(index, count));
    }

    @GetMapping(value = "{id}")
    public BookmarkGetByIdResponse getBookmarkById(@PathVariable String id) {
        return BookmarkMapper.INIT.BOOKMARK_GET_BY_ID_RESPONSE(bookmarkService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBookmark(@RequestBody BookmarkCreateRequest request) {
        UserProfile userProfile = userProfileService.getUserProfileById(request.userProfileId());
        var bookmark = BookmarkMapper.INIT.BOOKMARK_CREATE_REQUEST_TO_BOOKMARK(request);
        bookmark.setUserProfile(userProfile);
        bookmarkService.save(bookmark);
    }

    @PutMapping(value = "{id}/posts")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addPostToBookmark(@PathVariable String id, @RequestBody List<String> postIds){
        bookmarkService.addPostToBookmark(postIds,id);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookmark(@PathVariable String id){
        bookmarkService.deleteById(id);
    }
}
