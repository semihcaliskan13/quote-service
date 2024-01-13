package com.land.quotebackend.init;

import com.land.quotebackend.entity.Post;
import com.land.quotebackend.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {

    private final PostRepository postRepository;

    public Init(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //postRepository.save(new Post(null,"ds","hello quotess",null,null));
        //postRepository.save(new Post(null,"ds","hello quotes2",null,null));
        //postRepository.save(new Post(null,"ds","hello quotes3",null,null));
    }
}
