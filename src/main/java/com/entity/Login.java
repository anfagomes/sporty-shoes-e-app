package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Login {
	
	@Id
	private String emailId;
	private String username;
	private String password;
	private Integer userTypeId;
	
	
	public Login(String emailId, String username, String password, Integer userTypeId) {
		super();
		this.emailId = emailId;
		this.username = username;
		this.password = password;
		this.userTypeId = userTypeId;
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


	public Integer getUserTypeId() {
		return userTypeId;
	}


	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}
	
	


//	public UserType getUserType() {
//		return userType;
//	}
//
//
//	public void setUserType(UserType userType) {
//		this.userType = userType;
//	}
	
	
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
