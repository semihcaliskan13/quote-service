package com.land.quotebackend.service.impl;

import com.land.quotebackend.entity.Bookmark;
import com.land.quotebackend.repository.generic.GenericRepository;
import com.land.quotebackend.service.BookmarkService;
import com.land.quotebackend.service.generic.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BookmarkServiceImpl extends GenericServiceImpl<Bookmark> implements BookmarkService {


    public BookmarkServiceImpl(GenericRepository<Bookmark, String> repository) {
        super(repository);
    }
}
