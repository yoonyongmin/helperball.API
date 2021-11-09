package com.oknym.helperball.model;

import java.util.List;

import javax.persistence.CascadeType;
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
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "WEIGHT")
	private int weight;
	
	@Column(name = "HEIGHT")
	private int height;
	
	@Column(name = "AGE")
	private int age;
	
	@Column(name = "FOOT")
	private String foot;
	
	@Column(name = "POSITION")
	private String position;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Stat> stat;
	
}
