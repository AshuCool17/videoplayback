/**
 * 
 */
package com.continuecoding.videostreamingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.continuecoding.videostreamingapp.model.User;

/**
 * @author Ashutosh
 *
 */
public interface UserRepository extends MongoRepository<User, String>{

	User findBySub(String sub);

}
