package com.land.quotebackend.excepiton;

public class AwsS3BucketNotExist extends RuntimeException{

    public AwsS3BucketNotExist() {
    }

    public AwsS3BucketNotExist(String message) {
        super(message);
    }
}
