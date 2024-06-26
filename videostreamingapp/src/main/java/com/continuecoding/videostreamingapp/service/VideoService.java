/**
 * 
 */
package com.continuecoding.videostreamingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.continuecoding.videostreamingapp.dto.UploadVideoResponse;
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
	
	public UploadVideoResponse uploadVideo(MultipartFile file) {
		String videoUrl = s3Service.uploadFile(file);
		Video video = new Video();
		video.setVideoUrl(videoUrl);
		Video savedVideo = videoRepository.save(video);
		return new UploadVideoResponse(savedVideo.getId(), savedVideo.getVideoUrl());
		
	}

	public VideoDto editVideo(VideoDto videoDto) {
		//find the video by id;
		Video savedVideo = getVideoById(videoDto.getId());
		//map the videodto fields to video
		savedVideo.setTitle(videoDto.getTitle());
		savedVideo.setDescription(videoDto.getDescription());
		savedVideo.setTags(videoDto.getTags());
		savedVideo.setThumbnailUrl(videoDto.getThumbnailUrl());
		savedVideo.setVideoStatus(videoDto.getVideoStatus());
		//save the video to the DB
		videoRepository.save(savedVideo);
		return videoDto;
	}

	public String uploadThumbnail(MultipartFile file, String videoId) {
		Video savedVideo = getVideoById(videoId);
		String thumbnailUrl = s3Service.uploadFile(file);
		savedVideo.setThumbnailUrl(thumbnailUrl);
		videoRepository.save(savedVideo);
		return thumbnailUrl;
	}
	
	public Video getVideoById(String videoId) {
		return videoRepository.findById(videoId)
				.orElseThrow(()-> new IllegalArgumentException("Cannot find video by id - " + videoId));
	}

	public VideoDto getVideoDetails(String videoId) {
		Video savedVideo = getVideoById(videoId);
		
		VideoDto videoDto = new VideoDto();
		videoDto.setId(savedVideo.getId());
		videoDto.setTitle(savedVideo.getTitle());
		videoDto.setDescription(savedVideo.getDescription());
		videoDto.setThumbnailUrl(savedVideo.getThumbnailUrl());
		videoDto.setTags(savedVideo.getTags());
		videoDto.setVideoStatus(savedVideo.getVideoStatus());
		videoDto.setVideoUrl(savedVideo.getVideoUrl());
		
		return videoDto;
	}
}
