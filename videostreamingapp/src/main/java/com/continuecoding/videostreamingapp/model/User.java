/**
 * 
 */
package com.continuecoding.videostreamingapp.model;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ashutosh
 *
 */
@Document(value = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private String fullName;
	
	private String email;
	
	private Set<String> subscribedToUsers = ConcurrentHashMap.newKeySet();
	
	private Set<String> subscribers = ConcurrentHashMap.newKeySet();
	
	private Set<String> videoHistory = ConcurrentHashMap.newKeySet();
	
	private Set<String> likedVideos = ConcurrentHashMap.newKeySet();
	
	private Set<String> dislikedVideos = ConcurrentHashMap.newKeySet();

	public void addToLikedVideos(String videoId) {
		likedVideos.add(videoId);
	}

	public void removeFromLikedVideos(String videoId) {
		likedVideos.remove(videoId);
	}

	public void addToDisLikedVideos(String videoId) {
		dislikedVideos.add(videoId);
	}
	
	public void removeFromDisLikedVideos(String videoId) {
		dislikedVideos.remove(videoId);
	}

	public void addToVideoHistory(String videoId) {
		videoHistory.add(videoId);
	}

	public void addToSubscribedToUsers(String userId) {
		subscribedToUsers.add(userId);
	}

	public void addToSubscribers(String userId) {
		subscribers.add(userId);
	}

	public void removeFromSubscribedToUsers(String userId) {
		subscribers.remove(userId);
	}

	public void removeFromUnsubscribers(String userId) {
		
	}
}
