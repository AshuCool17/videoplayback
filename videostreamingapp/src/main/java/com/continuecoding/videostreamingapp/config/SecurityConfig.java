/**
 * 
 */
package com.continuecoding.videostreamingapp.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtValidators;

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
		
		OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator(audience);
		OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
		OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator(withIssuer, );
	}

}
