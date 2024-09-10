/**
 * 
 */
package com.continuecoding.videostreamingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.continuecoding.videostreamingapp.dto.CommentDto;
import com.continuecoding.videostreamingapp.dto.UploadVideoResponse;
import com.continuecoding.videostreamingapp.dto.VideoDto;
import com.continuecoding.videostreamingapp.service.VideoService;

/**
 * @author Ashutosh
 *
 */
@RestController(value = "/api/videos")
public class VideoController {

	@Autowired
	private VideoService videoService; 
	
	@PostMapping
	private UploadVideoResponse uploadVideo(@RequestParam("file") MultipartFile file) {
		return videoService.uploadVideo(file);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	private String uploadThumbnail(@RequestParam("file") MultipartFile file,
			@RequestParam("videoId") String videoId) {
		return videoService.uploadThumbnail(file, videoId);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public VideoDto editVideoMetadata(@RequestBody VideoDto videoDto){
		return videoService.editVideo(videoDto);
	}
	
	@GetMapping(value = "/{videoId}")
	@ResponseStatus(HttpStatus.OK)
	public VideoDto getVideoDetails(@PathVariable String videoId) {
		return videoService.getVideoDetails(videoId);
	}
	
	@PostMapping(value = "/{videoId}/like")
	@ResponseStatus(HttpStatus.OK)
	public VideoDto likeVideo(@PathVariable String videoId) {
		return videoService.likeVideo(videoId);
	}
	
	@PostMapping(value = "/{videoId}/disLike")
	@ResponseStatus(HttpStatus.OK)
	public VideoDto disLikeVideo(@PathVariable String videoId) {
		return videoService.disLikeVideo(videoId);
	}
	
	@PostMapping(value = "/{videoId}/comment")
	@ResponseStatus(HttpStatus.OK)
	public void addComment(@PathVariable String videoId, @RequestBody CommentDto commentDto) {
		videoService.addComment(videoId, commentDto);
	}
}
