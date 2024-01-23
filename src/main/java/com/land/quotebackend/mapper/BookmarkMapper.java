package com.land.quotebackend.mapper;

import com.land.quotebackend.dto.response.bookmark.BookmarkGetAllResponse;
import com.land.quotebackend.dto.response.bookmark.BookmarkGetByIdResponse;
import com.land.quotebackend.entity.Bookmark;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookmarkMapper {

    BookmarkMapper INIT = Mappers.getMapper(BookmarkMapper.class);

    List<BookmarkGetAllResponse> BOOKMARK_GET_ALL_RESPONSES(List<Bookmark> bookmarks);
    BookmarkGetByIdResponse BOOKMARK_GET_BY_ID_RESPONSE(Bookmark bookmark);
}
