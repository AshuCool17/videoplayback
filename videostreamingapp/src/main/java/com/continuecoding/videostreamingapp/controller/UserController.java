/**
 * 
 */
package com.continuecoding.videostreamingapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.continuecoding.videostreamingapp.service.UserRegistrationService;
import com.continuecoding.videostreamingapp.service.UserService;

import lombok.RequiredArgsConstructor;

/**
 * @author Ashutosh
 *
 */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

	private final UserRegistrationService userRegistrationService;
	
	private final UserService userService;
	
	@GetMapping("/register")
	public String register(Authentication authentication) {
		Jwt jwt = (Jwt)authentication.getPrincipal();
		return "User Registration Successfull";
	}
	
	@PostMapping("subscribe/{userId}")
	public void subscribeUser(@PathVariable String userId) {
		userService.subscribeUser(userId);
	}
	
	public void unsubscribeUser(@PathVariable String userId) {
	}
}
