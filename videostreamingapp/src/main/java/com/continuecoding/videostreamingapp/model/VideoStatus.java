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
@Document(value = "videoStatus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoStatus {
	
	private long id;

}
