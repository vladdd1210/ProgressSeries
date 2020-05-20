package com.progresseries.operationsdb;
import com.progresseries.db.*;
import java.sql.*;
import java.util.ArrayList;
public class GetEpisode {
	private static String url  = "jdbc:mysql://localhost/Progress";
	private static String dbLogin  = "root";
	private static String dbPassword  = "vvo200012312455";
	public static ArrayList<Episode> getEpisodesByTitleID (int insertedIDTitle) {
		ArrayList<Episode> episodes = new ArrayList<Episode>();
		String querry="SELECT * FROM Episode WHERE IDTitle=? ORDER BY Name";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, dbLogin, dbPassword);
			try {
				PreparedStatement st=con.prepareStatement(querry);
				st.setInt(1, insertedIDTitle);
				ResultSet rs=st.executeQuery();
				while (rs.next()) {
					 int iDEpisode=rs.getInt(1);
					 String name=rs.getString(2);
					 String description=rs.getString(3);
					 double length=rs.getDouble(4);
					 int iDTitle=rs.getInt(5);
					 Episode episode = new Episode(iDEpisode, name, description, length, iDTitle);
					 episodes.add(episode);
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
			System.out.println(episodes);

		}
		return episodes;
	}
	
	
	public static ArrayList<Episode> getEpisodesByEpisodeID (int insertedIDEpisode) {
		ArrayList<Episode> episodes = new ArrayList<Episode>();
		String querry="SELECT * FROM Episode WHERE IDEpisode=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, dbLogin, dbPassword);
			try {
				PreparedStatement st=con.prepareStatement(querry);
				st.setInt(1, insertedIDEpisode);
				ResultSet rs=st.executeQuery();
				while (rs.next()) {
					 int iDEpisode=rs.getInt(1);
					 String name=rs.getString(2);
					 String description=rs.getString(3);
					 double length=rs.getDouble(4);
					 int iDTitle=rs.getInt(5);
					 Episode episode = new Episode(iDEpisode, name, description, length, iDTitle);
					 episodes.add(episode);
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
			System.out.println(episodes);

		}
		return episodes;
	}
	
}
