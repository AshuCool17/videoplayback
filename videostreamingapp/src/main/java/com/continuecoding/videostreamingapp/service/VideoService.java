/**
 * 
 */
package com.continuecoding.videostreamingapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.continuecoding.videostreamingapp.model.Video;

import lombok.RequiredArgsConstructor;

/**
 * @author Ashutosh
 *
 */
@Service
@RequiredArgsConstructor
public class VideoService {
	
	private final FileService fileService;
	
	public void uploadVideo(MultipartFile file) {
		String videoUrl = S3Service.uploadFile(file);
		String video = new Video();
		
	}

}
