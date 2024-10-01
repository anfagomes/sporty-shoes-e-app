package com.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="useraccount")
public class UserAccount {
	
	@Id
	private String emailid;
	private String password;
	private String username;
	private String status;
	private String usertype;
	
	
	public UserAccount() {
		super();
	}
	
	public UserAccount(String emailid, String password, String username, String status, String usertype) {
		super();
		this.emailid = emailid;
		this.password = password;
		this.username = username;
		this.status = status;
		this.usertype = usertype;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "UserAccount [emailid=" + emailid + ", password=" + password + ", username=" + username + ", status="
				+ status + ", usertype=" + usertype + "]";
	}

}
