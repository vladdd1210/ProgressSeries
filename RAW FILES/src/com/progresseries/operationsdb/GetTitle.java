package com.progresseries.operationsdb;
import com.progresseries.db.*;
import java.sql.*;
import java.util.ArrayList;
public class GetTitle {
	private static String url  = "jdbc:mysql://localhost/Progress";
	private static String dbLogin  = "root";
	private static String dbPassword  = "vvo200012312455";
	public static ArrayList<Title> getTitleByID (int insertIDTitle) {
		ArrayList<Title> titles = new ArrayList<Title>();
		String querry="SELECT * FROM Title WHERE IDTitle=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, dbLogin, dbPassword);
			try {
				PreparedStatement st=con.prepareStatement(querry);
				st.setInt(1, insertIDTitle);
				ResultSet rs=st.executeQuery();
				while (rs.next()) {
					 int iDTitle=rs.getInt(1);
					 String name=rs.getString(2);
					 String description=rs.getString(3);
					 Title title = new Title(iDTitle, name, description);
					 titles.add(title);
					 
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
			System.out.println(titles);

		}
		return titles;
	}
	
	public static ArrayList<Title> getTitles () {
		ArrayList<Title> titles = new ArrayList<Title>();
		String querry="SELECT * FROM Title";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, dbLogin, dbPassword);
			try {
				PreparedStatement st=con.prepareStatement(querry);
				ResultSet rs=st.executeQuery();
				while (rs.next()) {
					 int iDTitle=rs.getInt(1);
					 String name=rs.getString(2);
					 String description=rs.getString(3);
					 Title title = new Title(iDTitle, name, description);
					 titles.add(title);
					 
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
			System.out.println(titles);

		}
		return titles;
	}
	
}
