/**
 * 
 */
package com.continuecoding.videostreamingapp.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;

import lombok.RequiredArgsConstructor;

/**
 * @author Ashutosh
 *
 */
@Service
@RequiredArgsConstructor
public class S3Service implements FileService {
	
	private static final String BUCKET_NAME = "youtube-demo-bucket";

	private static final AmazonS3Client amazonS3Client = new AmazonS3Client();
	
	public String uploadFile(MultipartFile file) {
		String fileNameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
		String key = UUID.randomUUID().toString() + fileNameExtension;
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(file.getSize());
		metadata.setContentType(file.getContentType());
		
		try {
			amazonS3Client.putObject("video-streaming", key, file.getInputStream(), metadata);
		} catch (SdkClientException | IOException e) {
			e.printStackTrace();
		}
		
		amazonS3Client.setObjectAcl(BUCKET_NAME, key, CannedAccessControlList.PublicRead);
		return amazonS3Client.getResourceUrl(BUCKET_NAME, key);
	}

	
}
