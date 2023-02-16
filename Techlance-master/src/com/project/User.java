package com.project;

public class User {
	
	String name;
	String email;
	String address;
	String imagePath;
	String type;
	String description;
	float rating;

	public User(String name,String email,String address,String imagePath,String type) {
		this.name = name;
		this.email = email;
		this.address = address;		
		this.imagePath = imagePath;	
		this.type = type;
	}
	
	public User(String name,String email,String address,String imagePath,String type,String description) {
		this.name = name;
		this.email = email;
		this.address = address;		
		this.imagePath = imagePath;	
		this.type = type;
		this.description = description;
	}
	
	public User(String name,String email,String address,String type,float rating) {
		this.name = name;
		this.email = email;
		this.address = address;			
		this.type = type;
		this.rating = rating;
	}
	
	
	
	public String getDescription() {
		return description;
	}

	public float getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getType() {
		return type;
	}	

	public void setType(String t) {
		this.type = t;
		
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
   
	
	
}
