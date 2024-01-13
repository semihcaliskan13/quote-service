package com.land.quotebackend.api.controller;

import com.land.quotebackend.dto.request.PostCreateRequest;
import com.land.quotebackend.dto.request.PostUpdateRequest;
import com.land.quotebackend.dto.response.PostGetAllResponse;
import com.land.quotebackend.dto.response.PostGetByIdResponse;
import com.land.quotebackend.entity.Post;
import com.land.quotebackend.mapper.PostMapper;
import com.land.quotebackend.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostGetAllResponse> getAllPosts(@RequestParam int pageIndex, @RequestParam int count) {

        return PostMapper.INIT.postsToGetAllResponse(postService.getAllPosts(pageIndex, count));
    }

    @GetMapping(value = "{id}")
    public PostGetByIdResponse getPostById(@PathVariable String id) {
        return PostMapper.INIT.postToGetByIdResponse(postService.getPostById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostCreateRequest request) {
        Post post = PostMapper.INIT.createPostRequestToPost(request);
        postService.createPost(post);
    }

    @PutMapping
    public void updatePost(@RequestBody PostUpdateRequest request) {
        Post post = PostMapper.INIT.updatePostRequestToPost(request);
        postService.updatePost(post);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePostById(@PathVariable String id) {
        postService.deletePostById(id);
    }
}
