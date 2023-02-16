package dec20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thane?useSSL=false","parag",
				"parag123");
			Statement s = con.createStatement();
		     ResultSet rs = s.executeQuery("select avg(marks) from student77");
	        rs.next();
	        float avg = rs.getFloat(1);
	        System.out.println("average marks of records in the student77_data table: "+avg);
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(c);
		

	}

}
