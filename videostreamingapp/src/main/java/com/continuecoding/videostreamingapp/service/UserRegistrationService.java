/**
 * 
 */
package com.continuecoding.videostreamingapp.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * @author Ashutosh
 *
 */
@Service
@RequiredArgsConstructor
public class UserRegistrationService {
	
	private String userInfoEndpoint;
	
	private final UserRepository userRepository;

}
