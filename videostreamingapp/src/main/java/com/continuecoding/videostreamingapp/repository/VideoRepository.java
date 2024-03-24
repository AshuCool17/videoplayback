/**
 * 
 */
package com.continuecoding.videostreamingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.continuecoding.videostreamingapp.model.Video;

/**
 * @author Ashutosh
 *
 */
public interface VideoRepository extends MongoRepository<Video, String>{

}
