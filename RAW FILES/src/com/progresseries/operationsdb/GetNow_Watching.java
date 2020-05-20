package com.progresseries.operationsdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.progresseries.db.Now_Watching;


public class GetNow_Watching {
	private static String url  = "jdbc:mysql://localhost/Progress";
	private static String dbLogin  = "root";
	private static String dbPassword  = "vvo200012312455";
	public static ArrayList<Now_Watching> getNow_WachingByUserID (int insertIDUser) {
	ArrayList<Now_Watching> nowWatching = new ArrayList<Now_Watching>();
	String querry="SELECT * FROM Now_Watching WHERE IDUser=?";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, dbLogin, dbPassword);
		try {
			PreparedStatement st=con.prepareStatement(querry);
			st.setInt(1, insertIDUser);
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				 int iDEpisode=rs.getInt(1);
				 int iDUser=rs.getInt(2);
				 int iDTitle=rs.getInt(3);
				 Now_Watching nowWatching1 = new Now_Watching(iDEpisode, iDUser, iDTitle);
				 nowWatching.add(nowWatching1);
				 
			}
		}
		catch (Exception ex) {
			System.out.println(ex);
		} finally {
			con.close();

		}
	}
	catch (Exception ex) {
		System.out.println(ex);
	} finally {
		System.out.println(nowWatching);
	}
	return nowWatching;
 }
	
	public static ArrayList<Now_Watching> getNow_WachingByUserAndTitleID (int insertIDUser, int insertIDTitle) {
		ArrayList<Now_Watching> nowWatching = new ArrayList<Now_Watching>();
		String querry="SELECT * FROM Now_Watching WHERE (IDUser=?) AND (IDTitle=?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, dbLogin, dbPassword);
			try {
				PreparedStatement st=con.prepareStatement(querry);
				st.setInt(1, insertIDUser);
				st.setInt(2, insertIDTitle);
				ResultSet rs=st.executeQuery();
				while (rs.next()) {
					 int iDEpisode=rs.getInt(1);
					 int iDUser=rs.getInt(2);
					 int iDTitle=rs.getInt(3);
					 Now_Watching nowWatching1 = new Now_Watching(iDEpisode, iDUser, iDTitle);
					 nowWatching.add(nowWatching1);
					 
				}
			}
			catch (Exception ex) {
				System.out.println(ex);
			} finally {
				con.close();

			}
		}
		catch (Exception ex) {
			System.out.println(ex);
		} finally {
			System.out.println(nowWatching);
		}
		return nowWatching;
	 }
	
}
