package com.project;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.sql.Date;

public class Message {


	String sender;
	String receiver;
	String message;
	String date;
	
	
	public Message(String sender,String receiver,String message,Timestamp time) {
		
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

		this.date = sdf.format(time);
		
	}
	
	@Override
	public String toString() {
		
		return " sender " + sender + " receiver" + receiver + " message " + message + " date " + date;
	}
	
	public String getSender() {
		return sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public String getMessage() {
		return message;
	}

	public String getDate() {
		return date;
	}
	
	

}
