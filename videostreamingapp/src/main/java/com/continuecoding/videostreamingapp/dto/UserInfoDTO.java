package com.continuecoding.videostreamingapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class UserInfoDTO {

	private String id;
	@JsonProperty("sub")
	private String sub;
	@JsonProperty("given_name")
	private String givenName;
	@JsonProperty("family_name")
	private String familyName;
	
	private String name;
	
	private String picture;
	
	private String email;
}
