package dec20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Q11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a rno");
		int roll = sc.nextInt();
		System.out.println("Enter a name");
		String sname = sc.next();
		System.out.println("Enter marks");
		float smarks = sc.nextFloat();
		System.out.println("Enter date of birth");
		String sdob = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thane?useSSL=false","parag",
				"parag123");
			PreparedStatement s = con.prepareStatement("{ call insert77(?,?,?,?) }");
			s.setInt(1,roll);
			s.setString(2, sname);
			s.setFloat(3,smarks);
			s.setString(4, sdob);
			
			ResultSet flag = s.executeQuery();
			ResultSet data = s.executeQuery("select * from student77");
			while(data.next()) {
				System.out.println(data.getInt(1)+" "+data.getString(2)+" "+data.getFloat(3)+" "+data.getString(4));
			}
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
