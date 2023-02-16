package com.project;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Comment {
	
	String username;
	String comment;
	String time;
	
	public Comment(String username,String comment,Timestamp time) {
		this.username = username;
		this.comment = comment;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		this.time = sdf.format(time);
		
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
