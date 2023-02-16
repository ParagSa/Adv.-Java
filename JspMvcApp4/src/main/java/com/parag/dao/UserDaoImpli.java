package com.parag.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.parag.conn.MyConnection;
import com.parag.modal.User;

public class UserDaoImpli implements UserDao {
	private MyConnection myConn;

	public UserDaoImpli() {
		 myConn = new MyConnection();
	}
	public void save(User user) {
		// TODO Auto-generated method stub
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
	public boolean login(User user) {
		Boolean flag = false;
		try {
			Connection con = myConn.getConnection();
			PreparedStatement s = con.prepareStatement("select * from userDao where uname = ? and upass= ?");
			s.setString(1, user.getUname());
			s.setString(2, user.getUpass());
			
			ResultSet rs = s.executeQuery();
			if(rs.next()) {
				flag = true;
			}
			
			
			s.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public void upload(int uid, String image) {
		// TODO Auto-generated method stub
		try {
			Connection con = myConn.getConnection();
			PreparedStatement s = con.prepareStatement("update userDao set image =? where uid =?");
			s.setInt(2, uid);
			s.setString(1, image);
			
			
			int i = s.executeUpdate();
			s.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
