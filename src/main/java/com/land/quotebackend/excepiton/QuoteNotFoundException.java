package com.land.quotebackend.excepiton;

public class QuoteNotFoundException extends RuntimeException {
    public QuoteNotFoundException() {
    }

    public QuoteNotFoundException(String message) {
        super(message);
    }
}
