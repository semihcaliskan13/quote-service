package com.land.quotebackend.repository;

import com.land.quotebackend.entity.Post;
import com.land.quotebackend.entity.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,String> {

    Page<Post> findByUserProfile(UserProfile userProfile, Pageable pageable);
}
