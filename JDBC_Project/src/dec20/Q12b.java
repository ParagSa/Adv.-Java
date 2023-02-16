package dec20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;



public class Q12b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a id");
		int eid = sc.nextInt();
		System.out.println("Enter a name");
		String ename = sc.next();
		System.out.println("Enter salary");
		float salary = sc.nextFloat();
		System.out.println("Enter date of join");
		String doj = sc.next();
		
		
		System.out.println("Enter a address id");
		int aid = sc.nextInt();
		System.out.println("Enter a city");
		String city = sc.next();
		System.out.println("Enter country");
		String country = sc.next();
//		System.out.println("Enter date of join");
//		String doj = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thane?useSSL=false","parag",
				"parag123");
			con.setAutoCommit(false);
			PreparedStatement s = con.prepareStatement("insert into employee77 values(?,?,?,?)");
			s.setInt(1,eid);
			s.setString(2, ename);
			s.setFloat(3,salary);
			s.setString(4, doj);
			Savepoint beforeinsert
            = con.setSavepoint();
			
			int flag = s.executeUpdate();
			PreparedStatement s2 = con.prepareStatement("insert into address77 values(?,?,?,?)");
			s2.setInt(1,aid);
			s2.setString(2, city);
			s2.setString(3,country);
			s2.setInt(4, eid);
			
			Savepoint beforeinsertadd
            = con.setSavepoint();
			int flag2 = s2.executeUpdate();
			
//			con.commit();
			if(flag2!=1) {
				con.rollback(beforeinsert);
			}else {

			     con.commit();
			}
			
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
