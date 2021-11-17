package com.oknym.helperball.model.session;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "auth_session")
@Getter
@Setter
public class AuthSession {
	
	public AuthSession() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	protected Long id;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "USER_ACCESS")
	private String userAccess;
	
	@Column(name = "USER_SECRET")
	private String userSecret;
	
	@Column(name = "STATUS")
	private SessionStatusType status;
	
	@Column(name = "LAST_ACCESS_TIME")
	private Date lastAccessTime;
	
	@Column(name = "EXPIRED_DATE")
	private Date expireDate;

}
