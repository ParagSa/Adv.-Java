package dec21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class selectTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//load the driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thane?useSSL=false","parag",
				"parag123");
			PreparedStatement s = con.prepareStatement("select * from studentAdvJava");
//			Statement s = con.createStatement();
			ResultSet flag = s.executeQuery();
			while(flag.next()) {
				System.out.println(flag.getInt(1)+" "+flag.getString(2)+" "+
						flag.getFloat(3)+" "+flag.getString(4));
			}
			System.out.println("====================================");
			 flag = s.executeQuery();
			while(flag.next()) {
				System.out.println(flag.getInt(1)+" "+flag.getString(2));
			}
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
