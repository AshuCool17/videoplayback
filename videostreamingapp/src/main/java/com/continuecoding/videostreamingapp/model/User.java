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
@Document(value = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private long id;

}
