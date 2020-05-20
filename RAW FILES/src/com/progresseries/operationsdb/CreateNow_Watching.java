package com.progresseries.operationsdb;
import java.sql.*;

public class CreateNow_Watching {
	private static String url  = "jdbc:mysql://localhost/Progress";
	private static String dbLogin  = "root";
	private static String dbPassword  = "vvo200012312455";
	public static void create (int iDEpisode, int iDUser, int iDTitle) {
		String querry = "INSERT INTO Now_Watching(IDEpisode, IDUser, IDTitle) VALUES (?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, dbLogin, dbPassword);
			try {
				PreparedStatement st=con.prepareStatement(querry);
				st.setInt(1, iDEpisode);
				st.setInt(2, iDUser);
				st.setInt(3, iDTitle);
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
