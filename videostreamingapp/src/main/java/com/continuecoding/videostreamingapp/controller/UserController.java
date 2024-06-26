/**
 * 
 */
package com.continuecoding.videostreamingapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String register(Authentication authentication) {
		return "User Registration Successfull";
	}
}
