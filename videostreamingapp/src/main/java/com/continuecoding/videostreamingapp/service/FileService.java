/**
 * 
 */
package com.continuecoding.videostreamingapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Ashutosh
 *
 */
@Service
public interface FileService {

	void uploadFile(MultipartFile file);
}
