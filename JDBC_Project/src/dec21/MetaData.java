package dec21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaData {

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
			ResultSet rs = s.executeQuery();
			ResultSetMetaData rsmd =   rs.getMetaData();
			System.out.println(rsmd.getColumnCount());
			for(int i = 1; i<=rsmd.getColumnCount();i++) {
				System.out.println(rsmd.getColumnName(i));
			}
			
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
