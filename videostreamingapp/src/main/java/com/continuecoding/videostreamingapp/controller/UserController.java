/**
 * 
 */
package com.continuecoding.videostreamingapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ashutosh
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

	@GetMapping("/register")
	public String register() {
		
	}
}
