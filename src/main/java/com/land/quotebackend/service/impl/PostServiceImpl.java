package com.land.quotebackend.service.impl;

import com.land.quotebackend.entity.Post;
import com.land.quotebackend.excepiton.QuoteNotFoundException;
import com.land.quotebackend.repository.PostRepository;
import com.land.quotebackend.service.PostService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts(int pageIndex, int count) {
        Pageable pageable = PageRequest.of(pageIndex,count, Sort.by("createdAt").descending());
        var datas = postRepository.findAll(pageable).getContent();
        return datas;
    }

    @Override
    public Post getPostById(String id) {
        return postRepository.findById(id).orElseThrow(() ->new QuoteNotFoundException(id));
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        if (postRepository.existsById(post.getId())){
            return postRepository.save(post);
        }
        throw new QuoteNotFoundException();
    }

    @Override
    public void deletePostById(String id) {
        postRepository.deleteById(id);
    }
}
