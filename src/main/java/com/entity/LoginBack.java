package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*@Entity
@Table(name="login")*/
public class LoginBack {
	
	@Id
	private String emailid;
	private String password;
	
	public LoginBack(String emailId, String password) {
		super();
		this.emailid = emailId;
		this.password = password;
	}
	
	public LoginBack() {
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
	

}
