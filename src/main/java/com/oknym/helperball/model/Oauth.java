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
public class Oauth {
	
	public Oauth() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
//	@ManyToOne
//	@JoinColumn(name = "USER_ID")
//	private User user;
	
	@Column(name = "WEB")
	private String web;
	
	@Column(name = "VERIFICATION")
	private String verification;
	
	@Column(name = "REFRESHTOKEN")
	private String refreshToken;
	
}
