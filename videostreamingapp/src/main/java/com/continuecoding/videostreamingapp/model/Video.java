/**
 * 
 */
package com.continuecoding.videostreamingapp.model;

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

}
