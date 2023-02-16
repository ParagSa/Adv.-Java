package dec21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class updateTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//load the driver class
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a rno");
		int rno = sc.nextInt();
		System.out.println("Enter a name");
		String name = sc.next();
		System.out.println("Enter marks");
		float marks = sc.nextFloat();
		System.out.println("Enter date of birth");
		String dob = sc.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thane?useSSL=false","parag",
				"parag123");
			PreparedStatement s = con.prepareStatement("update studentAdvJava set name =?,marks =?,dob=? where rno=?");
			s.setInt(4,rno );
			s.setString(1, name);
			s.setFloat(2,marks);
			s.setString(3, dob);
		
			int flag = s.executeUpdate();
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
