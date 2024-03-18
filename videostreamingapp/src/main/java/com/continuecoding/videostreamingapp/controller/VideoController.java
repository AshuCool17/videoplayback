/**
 * 
 */
package com.continuecoding.videostreamingapp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Ashutosh
 *
 */
@RestController(value = "/api/videos")
public class VideoController {

	@PostMapping
	private void uploadVideo(@RequestParam("file") MultipartFile file) {
		
	}
}
