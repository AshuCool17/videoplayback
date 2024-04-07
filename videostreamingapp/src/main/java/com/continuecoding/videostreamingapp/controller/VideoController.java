/**
 * 
 */
package com.continuecoding.videostreamingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	private void uploadVideo(@RequestParam("file") MultipartFile file) {
		videoService.uploadVideo(file);
	}
	
	@PutMapping
	editVideoMetadata(@RequestBody VideoDto videoDto){
		
	}
}
