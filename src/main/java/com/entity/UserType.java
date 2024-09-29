package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usertype")
public class UserType {
	@Id
	private int userTypeId;
	private int userType;
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public UserType(int userTypeId, int userType) {
		super();
		this.userTypeId = userTypeId;
		this.userType = userType;
	}
	public UserType() {
		super();
	}
	
	

}
