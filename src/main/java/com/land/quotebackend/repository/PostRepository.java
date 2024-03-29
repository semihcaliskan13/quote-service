package com.land.quotebackend.repository;

import com.land.quotebackend.entity.Post;
import com.land.quotebackend.entity.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface PostRepository extends JpaRepository<Post,String> {

    Page<Post> findByUserProfile(UserProfile userProfile, Pageable pageable);
    Page<Post> findPostsByCreatedAtBetween(Instant startDate, Instant endDate, Pageable pageable);
    Page<Post> findPostsByContentContaining(String search_query, Pageable pageable);
}
