package com.project;

public interface DAOInterface {
	
	public void connect();
	
	public boolean insert(String fullName,String email,String password,String address,String tableName);
	
	public boolean addDescription(String username,String description,String tableName);
	
	public boolean addImage(String username,String imagePath,String tableName);
	
	public void close();	
	

}
