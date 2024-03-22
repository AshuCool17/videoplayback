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
import com.amazonaws.services.s3.model.ObjectMetadata;

import lombok.RequiredArgsConstructor;

/**
 * @author Ashutosh
 *
 */
@Service
@RequiredArgsConstructor
public class S3Service implements FileService {

	private final AmazonS3Client amazonS3Client;
	
	@Override
	public String uploadFile(MultipartFile file) {
		//to-do
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
		
		return null;
	}

	
}
