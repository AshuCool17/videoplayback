/**
 * 
 */
package com.continuecoding.videostreamingapp.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.continuecoding.videostreamingapp.repository.UserRepository;

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
		HttpRequest httpRequest = HttpRequest.newBuilder()
					.GET()
					.uri(URI.create(userInfoEndpoint))
					.setHeader("Authorization", String.format("Bearer %s", tokenValue))
					.build();
		
		HttpClient.newBuilder()
		.version(HttpClient.Version.HTTP_2)
		.build();
	}

}
