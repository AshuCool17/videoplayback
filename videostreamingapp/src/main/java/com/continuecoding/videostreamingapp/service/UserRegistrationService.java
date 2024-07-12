/**
 * 
 */
package com.continuecoding.videostreamingapp.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.continuecoding.videostreamingapp.dto.UserInfoDTO;
import com.continuecoding.videostreamingapp.repository.UserRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

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

		HttpClient httpClient = HttpClient.newBuilder()
				.version(HttpClient.Version.HTTP_2)
				.build();

		try {
			HttpResponse<String> responseString = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			String body = responseString.body();
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.readValue(body, UserInfoDTO.class);
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException("Exception happened while registering user");
		}

	}

}
