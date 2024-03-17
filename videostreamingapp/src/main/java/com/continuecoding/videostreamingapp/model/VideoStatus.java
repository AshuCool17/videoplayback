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
public enum VideoStatus {
	
	PUBLIC, PRIVATE, UNLISTED

}
