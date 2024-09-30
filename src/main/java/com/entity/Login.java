package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login")
public class Login {
	
	@Id
	private String emailid;
	private String password;
	private int userid;
	
	public Login(String emailId, String password, int userid) {
		super();
		this.emailid = emailId;
		this.password = password;
		this.userid = userid;
	}
	
	public Login() {
		super();
	}

	public String getEmailId() {
		return emailid;
	}
	public void setEmailId(String emailId) {
		this.emailid = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userid;
	}
	public void setUserId(int userId) {
		this.userid = userId;
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
