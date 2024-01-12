package com.land.quotebackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {

    private final QuoteRepository quoteRepository;

    public Init(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        quoteRepository.save(new Quote(null,"hello quotess"));
    }
}
