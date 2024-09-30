package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="useraccount")
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String username;
	private String status;
	private String usertype;
	
	private String emailid;
	
	@OneToOne
	@JoinColumn(name = "userid")
	public int getUserid() {
		return userid;
	}
	
	
	
	public UserAccount() {
		super();
	}
	
	
	public UserAccount(int userid, String username, String status, String usertype, String emailid) {
		super();
		this.userid = userid;
		this.username = username;
		this.status = status;
		this.usertype = usertype;
		this.emailid = emailid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", status=" + status + ", usertype=" + usertype
				+ ", emailid=" + emailid + "]";
	}
	
	

}
