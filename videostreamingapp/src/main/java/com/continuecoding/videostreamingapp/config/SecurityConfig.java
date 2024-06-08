/**
 * 
 */
package com.continuecoding.videostreamingapp.config;

/**
 * @author Ashutosh
 *
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorize()
	}

}
