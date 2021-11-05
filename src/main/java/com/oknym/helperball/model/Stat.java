package com.oknym.helperball.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Stat {
	
	public Stat() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "GOAL")
	private Long goal;

	@Column(name = "SHOOT")
	private Long shoot;

	@Column(name = "ASSIST")
	private Long assist;

	@Column(name = "PASS")
	private Long pass;

	@Column(name = "TACKLE")
	private Long tackle;

	@Column(name = "INTERCEPT")
	private Long intercept;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	@JsonBackReference
	private User user;

	public void setUser(String userId) {
		
	}

}
