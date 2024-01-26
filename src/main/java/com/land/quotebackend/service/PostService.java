package com.land.quotebackend.service;

import com.land.quotebackend.entity.Post;
import com.land.quotebackend.entity.UserProfile;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

public interface PostService {

    List<Post> getAllPosts(int pageIndex, int count, Instant startDate, Instant endDate);
    List<Post> getAllPostsByIds(List<String> ids);
    List<Post> getAllPostsByUserProfile(UserProfile userProfile, Integer index, Integer count);
    Post getPostById(String id);
    void createPost(Post post);
    void updatePost(Post post);
    void deletePostById(String id);
}
