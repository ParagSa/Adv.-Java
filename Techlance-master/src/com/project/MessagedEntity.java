package com.project;

public class MessagedEntity {
	
	String username;
	String fullname;
	String imagePath;
	
	public MessagedEntity(String username,String fullname,String imagePath){
		
		this.username = username;
		this.fullname = fullname;
		this.imagePath = imagePath;
		
	}

	public String getUsername() {
		return username;
	}

	public String getFullname() {
		return fullname;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
