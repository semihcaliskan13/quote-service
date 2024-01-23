package com.land.quotebackend.api.controller;

import com.land.quotebackend.dto.response.bookmark.BookmarkGetAllResponse;
import com.land.quotebackend.dto.response.bookmark.BookmarkGetByIdResponse;
import com.land.quotebackend.mapper.BookmarkMapper;
import com.land.quotebackend.service.BookmarkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookmarks")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @GetMapping
    public List<BookmarkGetAllResponse> getAllBookmarks(){
        return BookmarkMapper.INIT.BOOKMARK_GET_ALL_RESPONSES(bookmarkService.getAll(0, 2));
    }

    @GetMapping(value = "{id}")
    public BookmarkGetByIdResponse getBookmarkById(@PathVariable String id){
        return BookmarkMapper.INIT.BOOKMARK_GET_BY_ID_RESPONSE(bookmarkService.getById(id));
    }
}
