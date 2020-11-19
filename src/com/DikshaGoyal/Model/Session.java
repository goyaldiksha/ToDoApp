package com.DikshaGoyal.Model;

public class Session {

	public String sessionId;
	public int userId;
	
	public Session(String sessionId, int userId) {
		super();
		this.sessionId = sessionId;
		this.userId = userId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
