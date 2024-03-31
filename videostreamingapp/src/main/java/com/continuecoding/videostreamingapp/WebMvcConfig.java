/**
 * 
 */
package com.continuecoding.videostreamingapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Ashutosh
 *
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	public void addCorsMappings(CorsRegistry corsRegistry) {
		
	}
}
