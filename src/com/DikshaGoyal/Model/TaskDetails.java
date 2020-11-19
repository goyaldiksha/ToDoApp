package com.DikshaGoyal.Model;

public class TaskDetails {
	private int id;
	private String name;
	private String date;
	private int userId; 
	private String completed;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public String getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		if(completed==0)
			this.completed="No";
		else
			this.completed="Yes";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
