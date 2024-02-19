package com.hexaware.QuitQ.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sessionId;
	
	@Column(unique = true)
	private String token;
	
	@Column(unique = true)
	private long userId;
	
	private String userType;
	
	private LocalDateTime sessionStartTime;
	
	private LocalDateTime sessionEndTime;

	public UserSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserSession(long sessionId, String token, long userId, String userType, LocalDateTime sessionStartTime,
			LocalDateTime sessionEndTime) {
		super();
		this.sessionId = sessionId;
		this.token = token;
		this.userId = userId;
		this.userType = userType;
		this.sessionStartTime = sessionStartTime;
		this.sessionEndTime = sessionEndTime;
	}

	public long getSessionId() {
		return sessionId;
	}

	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long l) {
		this.userId = l;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public LocalDateTime getSessionStartTime() {
		return sessionStartTime;
	}

	public void setSessionStartTime(LocalDateTime sessionStartTime) {
		this.sessionStartTime = sessionStartTime;
	}

	public LocalDateTime getSessionEndTime() {
		return sessionEndTime;
	}

	public void setSessionEndTime(LocalDateTime sessionEndTime) {
		this.sessionEndTime = sessionEndTime;
	}
	
	
	
}
