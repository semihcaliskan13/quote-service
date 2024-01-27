package com.land.quotebackend.service.impl;

import com.land.quotebackend.entity.Bookmark;
import com.land.quotebackend.entity.UserProfile;
import com.land.quotebackend.repository.BookmarkRepository;
import com.land.quotebackend.repository.generic.GenericRepository;
import com.land.quotebackend.service.BookmarkService;
import com.land.quotebackend.service.PostService;
import com.land.quotebackend.service.generic.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkServiceImpl extends GenericServiceImpl<Bookmark> implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final PostService postService;

    public BookmarkServiceImpl(GenericRepository<Bookmark, String> repository, BookmarkRepository bookmarkRepository, PostService postService) {
        super(repository);
        this.bookmarkRepository = bookmarkRepository;
        this.postService = postService;
    }

    @Override
    public void addPostToBookmark(List<String> postIds, String bookmarkId) {
        var bookmark = bookmarkRepository.findById(bookmarkId).orElseThrow();
        var posts = postService.getAllPostsByIds(postIds);
        if (posts != null) {
            bookmark.getPosts().addAll(posts);
            bookmarkRepository.save(bookmark);
        }

    }

    @Override
    public List<Bookmark> getUserProfilesBookmarks(UserProfile userProfile) {
        return bookmarkRepository.findByUserProfile(userProfile);
    }
}
