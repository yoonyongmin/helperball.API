package com.oknym.helperball.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Setter;

import lombok.Getter;

@Entity
@Table(name = "helperball")
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn
	private String name;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Stat> stat;

}
