package com.oknym.helperball.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	private Date age;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "POSITION_ID")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name = "FOOT_ID")
	private Foot foot;
	
}
