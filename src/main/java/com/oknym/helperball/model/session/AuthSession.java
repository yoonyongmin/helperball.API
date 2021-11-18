package com.oknym.helperball.model.session;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
	public final static int defaultExpireInterval = 30;
	
	public AuthSession() {
		
	}
	
	public AuthSession(String userId) {
		
	}
	
	public AuthSession(String userId, String userAccessKey, String userSecretKey, SessionStatusType status) {
		super();
		
		setUserId(userId);
		setUserAccess(userAccessKey);
		setUserSecret(userSecretKey);
		setStatus(status);
		
		setLastAccessTime(GregorianCalendar.getInstance().getTime());
		
		Calendar expireDate = GregorianCalendar.getInstance();
		expireDate.add(Calendar.MINUTE, defaultExpireInterval);
		setExpireDate(expireDate.getTime());
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
	
	@Column(name = "EXPIRE_DATE")
	private Date expireDate;

}
