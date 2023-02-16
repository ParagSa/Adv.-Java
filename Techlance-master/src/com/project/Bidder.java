package com.project;


public class Bidder {
	String username;
	String fullname;
	float amt;
	float rating;

	public Bidder(String username,String fullname,float amt,float rating) {

		this.username = username;
		this.fullname = fullname;
		this.amt = amt;
		this.rating = rating;	


	}

	public Bidder(String username,float amt) {

		this.username = username;

		this.amt = amt;	


	}

	public String getUsername() {
		return username;

	}

	public String getFullname() {
		return fullname;
	}

	public float getAmt() {
		return amt;
	}

	public float getRating() {
		return rating;
	}







}
