/**
 * 
 */
package com.continuecoding.videostreamingapp.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import com.continuecoding.videostreamingapp.model.User;
import com.continuecoding.videostreamingapp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Ashutosh
 *
 */
@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	public User getCurrentUser() {
		
		String sub = ((Jwt) (SecurityContextHolder.getContext().getAuthentication().getPrincipal())).getClaim("sub");
		return userRepository.findBySub(sub).orElseThrow(()->new IllegalArgumentException("Cannot find user with id " + sub));
	}

	public void addToLikedVideos(String videoId) {
		User currentUser = getCurrentUser();
		currentUser.addToLikedVideos(videoId);
		userRepository.save(currentUser);
	}
	
	public boolean ifLikedVideo(String videoId) {
		return getCurrentUser().getLikedVideos().stream().anyMatch(likedVideo->likedVideo.equals(videoId));
	}
	
	public boolean ifDisLikedVideo(String videoId) {
		return getCurrentUser().getDislikedVideos().stream().anyMatch(dislikedVideo->dislikedVideo.equals(videoId));
	}
	
	public void removeFromLikedVideos(String videoId) {
		User currentUser = getCurrentUser();
		currentUser.removeFromLikedVideos(videoId);
		userRepository.save(currentUser);
	}
	
	public void addToDisLikedVideos(String videoId) {
		User currentUser = getCurrentUser();
		currentUser.addToDisLikedVideos(videoId);
		userRepository.save(currentUser);
	}
}
