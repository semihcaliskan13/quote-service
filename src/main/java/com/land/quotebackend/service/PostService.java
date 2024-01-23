package com.land.quotebackend.service;

import com.land.quotebackend.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts(int pageIndex, int count);
    List<Post> getAllPostsByIds(List<String> ids);
    Post getPostById(String id);
    Post createPost(Post post);
    Post updatePost(Post post);
    void deletePostById(String id);
}
