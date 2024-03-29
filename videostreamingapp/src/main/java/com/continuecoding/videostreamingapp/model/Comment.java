/**
 * 
 */
package com.continuecoding.videostreamingapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ashutosh
 *
 */
@Document(value = "comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	
	private long id;
	
	private String text;
	
	private String authorId;
	
	private Integer likeCount;
	
	private Integer dislikeCount;

}
