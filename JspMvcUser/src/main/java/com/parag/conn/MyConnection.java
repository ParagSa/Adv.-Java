package com.parag.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/thane?useSSL=false";
	private static final String USER_NAME = "parag";
	private static final String PASSWORD = "parag123";
	private Connection con;
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		if(con == null || con.isClosed()) {
			Class.forName(DRIVER_CLASS);
			con =DriverManager.getConnection(URL,USER_NAME,PASSWORD);
		}
		return con;
	}

}
