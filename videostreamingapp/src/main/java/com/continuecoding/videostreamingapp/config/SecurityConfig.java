/**
 * 
 */
package com.continuecoding.videostreamingapp.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoders;

/**
 * @author Ashutosh
 *
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.oauth2ResourceServer()
			.jwt();
	}
	
	@Bean
	JwtDecoder jwtDecoder() {
		NimbusJwtDecoder nimbusJwtDecoder = JwtDecoders.fromOidcIssuerLocation(issuer);
	}

}
