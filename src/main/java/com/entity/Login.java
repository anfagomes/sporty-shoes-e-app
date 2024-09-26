package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Login {
	
	@Id
	private String emailId;
	private String username;
	private String password;
	//private Role role;
	
	
	public Login(String emailId, String username, String password, Role role) {
		super();
		this.emailId = emailId;
		this.username = username;
		this.password = password;
		//this.role = role;
	}
	
	
	public Login() {
		super();
	}


	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public Role getRole() {
//		return role;
//	}
//	public void setRole(Role role) {
//		this.role = role;
//	}
//	@Override
//	public String toString() {
//		return "Login [emailId=" + emailId + ", username=" + username + ", password=" + password + ", role=" + role
//				+ "]";
//	}
	
	

}
