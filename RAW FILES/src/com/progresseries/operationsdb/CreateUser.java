package com.progresseries.operationsdb;
import java.sql.*;

public class CreateUser {
	private static String url  = "jdbc:mysql://localhost/Progress";
	private static String dbLogin  = "root";
	private static String dbPassword  = "vvo200012312455";
	public static void create (String userName, String userPassword) {
		String querry = "INSERT INTO User(UserName, UserPassword) VALUES (?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, dbLogin, dbPassword);
			try {
				PreparedStatement st=con.prepareStatement(querry);
				st.setString(1, userName);
				st.setString(2, userPassword);
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
