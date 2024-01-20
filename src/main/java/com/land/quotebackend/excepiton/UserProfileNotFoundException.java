package com.land.quotebackend.excepiton;

public class UserProfileNotFoundException extends RuntimeException{

    public UserProfileNotFoundException() {
    }

    public UserProfileNotFoundException(String message) {
        super(message);
    }
}
