/**
 * 
 */
package com.continuecoding.videostreamingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ashutosh
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadVideoResponse {

	private String videoId;
	private String videoUrl;
}
