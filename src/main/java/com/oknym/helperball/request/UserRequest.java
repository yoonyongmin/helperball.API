package com.oknym.helperball.request;

@SuppressWarnings("unused")
public class UserRequest {
	
	public UserRequest(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	private Long id;
	private String name;
	
}
