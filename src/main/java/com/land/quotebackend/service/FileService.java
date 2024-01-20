package com.land.quotebackend.service;

import com.land.quotebackend.entity.UserProfile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    String fileUpload(String bucketName, MultipartFile file, UserProfile userProfile) throws IOException;
}
