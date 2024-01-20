package com.land.quotebackend.service.impl;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.land.quotebackend.entity.UserProfile;
import com.land.quotebackend.excepiton.AwsS3BucketNotExist;
import com.land.quotebackend.service.FileService;
import com.land.quotebackend.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.UUID;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    private final AmazonS3 amazonS3;
    private final UserProfileService userProfileService;

    public FileServiceImpl(AmazonS3 amazonS3, UserProfileService userProfileService) {
        this.amazonS3 = amazonS3;
        this.userProfileService = userProfileService;
    }

    @Override
    public String fileUpload(String bucketName, MultipartFile file, UserProfile userProfile) throws IOException {
        String fileName = "";
        if(!amazonS3.doesBucketExistV2(bucketName)){
            throw new AwsS3BucketNotExist(MessageFormat.format("Bucket with bucketName: {0}",bucketName));
        }
        try {
            fileName = UUID.randomUUID() + file.getOriginalFilename();
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            amazonS3.putObject(bucketName, "myfolder/" + fileName, file.getInputStream(), metadata);
            userProfile.setImageUrl(amazonS3.getUrl(bucketName,"myfolder/"+fileName).toString());
            userProfileService.updateUserProfile(userProfile);
            log.info(MessageFormat.format("File with name: {0} uploaded to bucket with name: {1}",fileName,bucketName));
        }
        catch (SdkClientException | IOException e){
            log.error("File uploading exception" + e.getMessage());
        }
        return "File Uploaded Successfully \nFileName:- " + fileName;
    }
}
