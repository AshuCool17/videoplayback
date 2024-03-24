/**
 * 
 */
package com.continuecoding.videostreamingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.continuecoding.videostreamingapp.model.Video;
import com.continuecoding.videostreamingapp.repository.VideoRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Ashutosh
 *
 */
@Service
@RequiredArgsConstructor
public class VideoService {
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private VideoRepository videoRepository;
	
	public void uploadVideo(MultipartFile file) {
		String videoUrl = S3Service.uploadFile(file);
		String video = new Video();
		video.setVideoUrl(videoUrl);
		
		videoRepository.save(video);
	}

}
