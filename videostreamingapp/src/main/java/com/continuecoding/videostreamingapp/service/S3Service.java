/**
 * 
 */
package com.continuecoding.videostreamingapp.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.var;

/**
 * @author Ashutosh
 *
 */
@Service
public class S3Service implements FileService {

	@Override
	public void uploadFile(MultipartFile file) {
		//to-do
		String fileNameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
		String key = UUID.randomUUID().toString() + fileNameExtension;
	}

	
}
