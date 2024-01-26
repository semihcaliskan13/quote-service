package com.land.quotebackend.repository;

import com.land.quotebackend.entity.Bookmark;
import com.land.quotebackend.entity.UserProfile;
import com.land.quotebackend.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends GenericRepository<Bookmark,String> {
    List<Bookmark> findByUserProfile(UserProfile userProfile);
}
