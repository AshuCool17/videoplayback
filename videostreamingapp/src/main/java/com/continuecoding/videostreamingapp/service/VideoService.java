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
		//find the video by id;
		Video savedVideo = videoRepository.findById(videoDto.getId())
		.orElseThrow(()-> new IllegalArgumentException("Cannot find video by id - " + videoDto.getId()));
		//map the videodto fields to video
		savedVideo.setTitle(videoDto.getTitle());
		savedVideo.setDescription(videoDto.getDescription());
		savedVideo.setTags(videoDto.getTags());
		savedVideo.setThumbnailUrl(videoDto.getThumbnailUrl());
		savedVideo.setVideoStatus(videoDto.getVideoStatus());
		//save the video to the DB
		videoRepository.save(savedVideo);
	}
}
