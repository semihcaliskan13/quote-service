package com.land.quotebackend.repository;

import com.land.quotebackend.entity.Bookmark;
import com.land.quotebackend.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends GenericRepository<Bookmark,String> {
}
