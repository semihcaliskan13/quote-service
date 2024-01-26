package com.land.quotebackend.api.controller;

import com.land.quotebackend.dto.request.post.PostCreateRequest;
import com.land.quotebackend.dto.request.post.PostUpdateRequest;
import com.land.quotebackend.dto.response.post.PostGetAllResponse;
import com.land.quotebackend.dto.response.post.PostGetByIdResponse;
import com.land.quotebackend.entity.Post;
import com.land.quotebackend.mapper.PostMapper;
import com.land.quotebackend.service.PostService;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
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

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostGetAllResponse> getAllPosts(@RequestParam int pageIndex,
                                                @RequestParam int count,
                                                @RequestParam @Nullable Instant startDate,
                                                @RequestParam @Nullable Instant endDate,
                                                @RequestParam @Nullable String search_query) {
        return PostMapper.INIT.postsToGetAllResponse(postService.getAllPosts(pageIndex, count, startDate, endDate,search_query));
    }

    @GetMapping(value = "{id}")
    public PostGetByIdResponse getPostById(@PathVariable String id) {
        return PostMapper.INIT.postToGetByIdResponse(postService.getPostById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody @Valid PostCreateRequest request) {
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
