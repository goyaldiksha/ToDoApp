package com.DikshaGoyal.Model;

public class User {
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", id=" + id + ", pass=" + pass + "]";
	}
	
	private String name;
	private String email;
	private int id;
	private String pass;
	
	public User(){}
	
	public User(String name, String email, int id, String pass) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
