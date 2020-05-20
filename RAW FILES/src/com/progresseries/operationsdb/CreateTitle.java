package com.progresseries.operationsdb;
import java.sql.*;

public class CreateTitle {
	private static String url  = "jdbc:mysql://localhost/Progress";
	private static String dbLogin  = "root";
	private static String dbPassword  = "vvo200012312455";
	public static void create (String name, String description) {
		String querry = "INSERT INTO Title(Name, Description) VALUES (?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, dbLogin, dbPassword);
			try {
				PreparedStatement st=con.prepareStatement(querry);
				st.setString(1, name);
				st.setString(2, description);
				st.executeUpdate();
				
			}
			catch (Exception ex) {
				System.out.println(ex);
			} finally {
				con.close();
			}
		}
		catch (Exception ex) {
			System.out.println(ex);
		} finally {	}
	}
}
