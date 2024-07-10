package com.continuecoding.videostreamingapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class UserInfoDTO {

	private String id;
	@JsonProperty("sub")
	private String sub;
	
	private String givenName;
	
	private String familyName;
	
	private String name;
	
	private String picture;
	
	private String email;
}
