package dec20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class deleteTable {

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
			Statement s = con.createStatement();
			int flag = s.executeUpdate("delete from studentAdvJava where rno="+rno+"");
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
