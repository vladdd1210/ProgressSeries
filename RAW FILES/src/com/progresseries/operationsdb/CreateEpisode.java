package com.progresseries.operationsdb;
import java.sql.*;

public class CreateEpisode {
	private static String url  = "jdbc:mysql://localhost/Progress";
	private static String dbLogin  = "root";
	private static String dbPassword  = "vvo200012312455";
	public static void create (String name, String description, double length, int iDTitle) {
		String querry = "INSERT INTO Episode(Name, Description, Length, IDTitle) VALUES (?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, dbLogin, dbPassword);
			try {
				PreparedStatement st=con.prepareStatement(querry);
				st.setString(1, name);
				st.setString(2, description);
				st.setDouble(3, length);
				st.setInt(4, iDTitle);
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
