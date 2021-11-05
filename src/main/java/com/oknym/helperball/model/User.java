package com.oknym.helperball.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	
	public User() {
		
	}
	
	public User(String userId, String name, String password) {
		setUserId(userId);
		setName(name);
		setPassword(password);
	}
	
	public User(String userId, String name, String password, Info info, Stat stat) {
		setUserId(userId);
		setName(name);
		setPassword(password);
		setInfo(info);
		setStat(stat);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "PASSWORD")
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Stat> stat;

	@OneToMany(mappedBy = "user")
	private List<Info> info;

	public void setInfo(Info info) {
		
	}

	public void setStat(Stat stat) {
		
	}
	
}
