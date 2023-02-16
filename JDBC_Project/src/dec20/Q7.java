package dec20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Q7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//load the driver class
		System.out.println("Enter Roll no");
		Scanner sc = new Scanner(System.in);
		int roll = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thane?useSSL=false","parag",
				"parag123");
//			Statement s = con.createStatement();
			PreparedStatement s = con.prepareStatement("select * from student77 where rno = ?");
//			ResultSet flag = s.executeQuery("select * from student77 where rno = ?");
			s.setInt(1,roll );
//			while(flag.next()) {
//				System.out.println(flag.getInt(1)+" "+flag.getString(2));
//			}
			ResultSet flag = s.executeQuery();
			while(flag.next()) {
				System.out.println(flag.getInt(1)+" "+flag.getString(2)+" "+flag.getFloat(3)+" "+flag.getString(4));
			}
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
