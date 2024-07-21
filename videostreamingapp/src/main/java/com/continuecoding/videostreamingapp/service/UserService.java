/**
 * 
 */
package com.continuecoding.videostreamingapp.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import com.continuecoding.videostreamingapp.model.User;
import com.continuecoding.videostreamingapp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Ashutosh
 *
 */
@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	public User getCurrentUser() {
		
		((Jwt) (SecurityContextHolder.getContext().getAuthentication().getPrincipal())).getClaim("sub");
	}
}
