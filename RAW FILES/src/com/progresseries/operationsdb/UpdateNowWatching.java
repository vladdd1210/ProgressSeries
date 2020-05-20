package com.progresseries.operationsdb;
import java.sql.*;

public class UpdateNowWatching {
	private static String url  = "jdbc:mysql://localhost/Progress";
	private static String dbLogin  = "root";
	private static String dbPassword  = "vvo200012312455";
	public static void update (int insertedIDEpisode, int insertedIDUser, int insertedIDTitle) {
		String querry = "UPDATE Now_Watching SET IDEpisode = ? WHERE (IDUser = ?) AND (IDTitle = ?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, dbLogin, dbPassword);
			try {
				PreparedStatement st=con.prepareStatement(querry);
				st.setInt(1, insertedIDEpisode);
				st.setInt(2, insertedIDUser);
				st.setInt(3, insertedIDTitle);
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
