/**
 * 
 */
package com.continuecoding.videostreamingapp.model;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ashutosh
 *
 */
@Document(value = "Video")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {
	
	@Id
	private String id;
	
	private String title;
	
	private String description;
	
	private String userId;
	
	private AtomicInteger likes = new AtomicInteger(0);
	
	private AtomicInteger dislikes = new AtomicInteger(0);
	
	private Set<String> tags;
	
	private String videoUrl;
	
	private VideoStatus videoStatus;
	
	private AtomicInteger viewCount =  new AtomicInteger(0);
	
	private String thumbnailUrl;
	
	private List<Comment> commentList;
	
	public void incrementLikes() {
		likes.incrementAndGet();
	}
	
	public void decrementLikes() {
		dislikes.decrementAndGet();
	}
	
	public void incrementDislikes() {
		dislikes.incrementAndGet();
	}
	
	public void decrementDislikes() {
		dislikes.decrementAndGet();
	}
	
	private void incrementViewCount() {
		viewCount.incrementAndGet();
	}

}
