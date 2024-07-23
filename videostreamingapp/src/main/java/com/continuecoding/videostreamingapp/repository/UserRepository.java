/**
 * 
 */
package com.continuecoding.videostreamingapp.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.continuecoding.videostreamingapp.model.User;

/**
 * @author Ashutosh
 *
 */
public interface UserRepository extends MongoRepository<User, String>{

	Optional<User> findBySub(String sub);

}
