package com.oknym.helperball.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Stat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn
	private Long goal;

	@JoinColumn
	private Long shoot;

	@JoinColumn
	private Long assist;

	@JoinColumn
	private Long pass;

	@JoinColumn
	private Long tackle;

	@JoinColumn
	private Long intercept;
	
//	@ManyToOne
//	private User user;

}
