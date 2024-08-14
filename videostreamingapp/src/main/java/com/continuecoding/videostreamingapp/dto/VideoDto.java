/**
 * 
 */
package com.continuecoding.videostreamingapp.dto;

import java.util.Set;

import com.continuecoding.videostreamingapp.model.VideoStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ashutosh
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoDto {
	
	private String id;
	private String title;
	private String description;
	private Set<String> tags;
	private String videoUrl;
	private VideoStatus videoStatus;
	private String thumbnailUrl;
	private Integer likeCount;
	private Integer dislikeCount;
	private Integer viewCount;

}
