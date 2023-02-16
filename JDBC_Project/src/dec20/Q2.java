package dec20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thane?useSSL=false","parag",
				"parag123");
			Statement s = con.createStatement();
			int flag = s.executeUpdate("insert into student77 values(05,'sandy',65,'1999-09-10')"
					);
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
