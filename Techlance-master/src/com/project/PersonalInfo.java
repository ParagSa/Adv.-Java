package com.project;

public class PersonalInfo {

	String username;
	String userType;
	int[] countArray;
	
	public PersonalInfo(String username,String userType) {
		this.username = username;
		this.userType = userType;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public void setCountArray(int[] array) {
		this.countArray = new int[2];
		this.countArray = array;
	}
	
	public int[] getCountArray() {
		return this.countArray;
		
	}
}
