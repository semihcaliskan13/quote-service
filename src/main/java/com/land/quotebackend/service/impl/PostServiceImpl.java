package com.land.quotebackend.service.impl;

import com.land.quotebackend.entity.Post;
import com.land.quotebackend.entity.UserProfile;
import com.land.quotebackend.excepiton.QuoteNotFoundException;
import com.land.quotebackend.repository.PostRepository;
import com.land.quotebackend.repository.UserRepository;
import com.land.quotebackend.service.PostService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts(int pageIndex, int count, Instant startDate, Instant endDate) {
        Pageable pageable = PageRequest.of(pageIndex, count, Sort.by("createdAt").descending());
        if (startDate != null && endDate != null) {
            return postRepository.findPostsByCreatedAtBetween(startDate, endDate, pageable).getContent();
        }
        return postRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Post> getAllPostsByIds(List<String> ids) {
        return postRepository.findAllById(ids);
    }

    @Override
    public List<Post> getAllPostsByUserProfile(UserProfile userProfile, Integer index, Integer count) {
        Pageable pageable = PageRequest.of(index, count, Sort.by("createdAt").descending());
        return postRepository.findByUserProfile(userProfile, pageable).getContent();
    }

    @Override
    public Post getPostById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new QuoteNotFoundException(id));
    }

    @Override
    public void createPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void updatePost(Post post) {
        if (postRepository.existsById(post.getId())) {
            postRepository.save(post);
            return;
        }
        throw new QuoteNotFoundException();
    }

    @Override
    public void deletePostById(String id) {
        postRepository.deleteById(id);
    }
}
