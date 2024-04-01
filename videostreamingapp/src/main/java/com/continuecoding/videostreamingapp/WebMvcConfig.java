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

	@Configuration
	public void addCorsMappings(CorsRegistry corsRegistry) {
		
		corsRegistry.addMapping("/**")
		.allowedOrigins("*")
		.allowedMethods("GET","POST","PUT","DELETE","PATCH","OPTIONS")
		.allowedHeaders("*")
		.maxAge(3600);
	}
}
