package com.parag.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.parag.conn.MyConnection;
import com.parag.model.User;

public class UserDaoImpli implements UserDao{
	private MyConnection myConn;
	public UserDaoImpli() {
		myConn = new MyConnection();
	}

	@Override
	public void save(User user) {
		try {
			Connection con = myConn.getConnection();
			PreparedStatement s = con.prepareStatement("insert into userDao(uname,upass) values(?,?)");
			
			s.setString(1, user.getUname());
			s.setString(2 , user.getUpass());
			
			int i = s.executeUpdate();
			s.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean present(User user) {
		return false;
	}

}
