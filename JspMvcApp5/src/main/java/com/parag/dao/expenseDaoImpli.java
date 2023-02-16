package com.parag.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.parag.conn.MyConnection;
import com.parag.modal.Expense;

public class expenseDaoImpli implements expenseDao{
	private MyConnection myConn;

	public expenseDaoImpli() {
		 myConn = new MyConnection();
	}

	@Override
	public void save(Expense expense) {
		// TODO Auto-generated method stub
		try {
			Connection con = myConn.getConnection();
			PreparedStatement s = con.prepareStatement("insert into expense(item,price,quantity,edate,uid) values(?,?,?,?,?)");
			s.setString(1, expense.getItem());
			s.setFloat(2, expense.getPrice());
			s.setInt(3, expense.getQuantity());
			s.setString(4, expense.getEdate());
			s.setInt(5, expense.getUid());
			int i = s.executeUpdate();
			s.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Expense> selectAll(int uid) {
		
		List<Expense>lst = new ArrayList<>();
		try {
			Connection con = myConn.getConnection();
			PreparedStatement s = con.prepareStatement("select * from expense where uid=?");
			
			s.setInt(1, uid);
			ResultSet rs = s.executeQuery();
			while(rs.next()) {
				Expense expense = new Expense();
				expense.setId(rs.getInt(1));
				expense.setItem(rs.getString(2));
				expense.setPrice(rs.getFloat(3));
				
				expense.setQuantity(rs.getInt(4));
				expense.setEdate(rs.getString(5));
				expense.setUid(rs.getInt(6));
				lst.add(expense);
			}
			s.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public void deleteById(int id) {
		try {
			Connection con = myConn.getConnection();
			PreparedStatement s = con.prepareStatement("delete from expense where id =?");
		    s.setInt(1, id);
			int i = s.executeUpdate();
			s.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Expense selectById(int id) {
		Expense expense = new Expense();
		try {
			Connection con = myConn.getConnection();
			PreparedStatement s = con.prepareStatement("select * from expense where id=?");
			
			s.setInt(1, id);
			ResultSet rs = s.executeQuery();
			if(rs.next()) {
			
				expense.setId(rs.getInt(1));
				expense.setItem(rs.getString(2));
				expense.setPrice(rs.getFloat(3));
				
				expense.setQuantity(rs.getInt(4));
				expense.setEdate(rs.getString(5));
				expense.setUid(rs.getInt(6));
				
			}
			s.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return expense;
		
	}

	@Override
	public void update(Expense expense) {
	
		try {
			Connection con = myConn.getConnection();
			PreparedStatement s = con.prepareStatement("update expense set item=?, price=?,quantity=?,edate=? where id=?");
			s.setString(1, expense.getItem());
			s.setFloat(2, expense.getPrice());
			s.setInt(3, expense.getQuantity());
			s.setString(4, expense.getEdate());
			s.setInt(5, expense.getId());
			int i = s.executeUpdate();
			
			
			s.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
