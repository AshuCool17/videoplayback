/**
 * 
 */
package com.continuecoding.videostreamingapp.service;

import java.net.URI;

import org.apache.http.HttpRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * @author Ashutosh
 *
 */
@Service
@RequiredArgsConstructor
public class UserRegistrationService {
	
	@Value("${auth0.userInfoEndpoint}")
	private String userInfoEndpoint;
	
	private final UserRepository userRepository;
	
	public void registerUser(String tokenValue) {
		HttpRequest.newBuilder()
					.GET()
					.uri(URI.create(userInfoEndpoint))
	}

}
