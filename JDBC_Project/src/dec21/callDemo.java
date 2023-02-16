package dec21;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;




public class callDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//load the driver class
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a rno");
		int rno = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thane?useSSL=false","parag",
				"parag123");
			CallableStatement s = con.prepareCall("{ call my_proc(?)}");
			s.setInt(1, rno);
			int flag = s.executeUpdate();
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
