package com.oknym.helperball.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@Column(name = "goal")
	private Long goal;

	@Column(name = "shoot")
	private Long shoot;

	@Column(name = "assist")
	private Long assist;

	@Column(name = "pass")
	private Long pass;

	@Column(name = "tackle")
	private Long tackle;

	@Column(name = "intercept")
	private Long intercept;
	
	@JsonBackReference
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@MapsId
	private User user;
	
//	@OneToMany(mappedBy = "stat", fetch = FetchType.EAGER)
//	private List<User> user;
	
//	@Column(name = "user_id")
//	private Long userId;
	

}
