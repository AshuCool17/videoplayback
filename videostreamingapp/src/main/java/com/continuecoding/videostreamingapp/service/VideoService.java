/**
 * 
 */
package com.continuecoding.videostreamingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.continuecoding.videostreamingapp.dto.VideoDto;
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
	private S3Service s3Service;
	@Autowired
	private VideoRepository videoRepository;
	
	public void uploadVideo(MultipartFile file) {
		String videoUrl = s3Service.uploadFile(file);
		Video video = new Video();
		video.setVideoUrl(videoUrl);
		
		videoRepository.save(video);
	}

	public void editVideo(VideoDto videoDto) {
		
	}
}
