package com.land.quotebackend.service;

import com.land.quotebackend.entity.Bookmark;
import com.land.quotebackend.entity.UserProfile;
import com.land.quotebackend.service.generic.GenericService;

import java.util.List;

public interface BookmarkService extends GenericService<Bookmark> {

    void addPostToBookmark(List<String> postIds, String bookmarkId);

    List<Bookmark> getUserProfilesBookmarks(UserProfile userProfile);
}
