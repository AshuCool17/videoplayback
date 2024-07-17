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
	
	private AtomicInteger likes;
	
	private Integer dislikes;
	
	private Set<String> tags;
	
	private String videoUrl;
	
	private VideoStatus videoStatus;
	
	private Integer viewCount;
	
	private String thumbnailUrl;
	
	private List<Comment> commentList;
	
	public void incrementLikes() {
		likes.incrementAndGet();
	}
	
	public void decrementLikes() {
		this.dislikes = dislikes++;
	}

}
