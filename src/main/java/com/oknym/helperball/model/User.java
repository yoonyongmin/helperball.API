package com.oknym.helperball.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	
	public User() {
		
	}
	
//	@Builder
//	public User(String name, String email, String picture, Role role) {
//		this.name = name;
//		this.email = email;
//		this.picture = picture;
//		this.role = role;
//	}
//	
//	public User update(String name, String picture) {
//		this.name = name;
//		this.picture = picture;
//		return this;
//	}
//	
//	public String getRoleKey() {
//		return this.role.getKey();
//	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "token")
	private String token;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
//	@Column(name = "email")
//	private String email;
//	
//	@Column(name = "picture")
//	private String picture;
//	
//	@Column(name = "role")
//	private String role = "ROLE_USER";
	
//	@Enumerated(EnumType.STRING)
//	@Column(name = "role")
//	private Role role;

}
