/**
 * 
 */
package com.continuecoding.videostreamingapp.model;

import java.util.Set;

import org.springframework.data.annotation.Id;

/**
 * @author Ashutosh
 *
 */
public class Video {
	
	@Id
	private long id;
	
	private String title;
	
	private String description;
	
	private String userId;
	
	private Integer likes;
	
	private Integer dislikes;
	
	private Set<String> tags;
	
	private String videoUrl;

}
