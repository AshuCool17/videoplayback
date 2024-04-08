/**
 * 
 */
package com.continuecoding.videostreamingapp.dto;

import java.util.Set;

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

}
