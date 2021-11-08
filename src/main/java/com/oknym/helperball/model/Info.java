package com.oknym.helperball.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Info {
	
	public Info() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "WEIGHT")
	private int weight;
	
	@Column(name = "HEIGHT")
	private int height;
	
	@Column(name = "AGE")
	private int age;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	@JsonBackReference
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "POSITION_ID")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name = "FOOT_ID")
	private Foot foot;
	
}
