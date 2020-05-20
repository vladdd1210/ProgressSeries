package com.progresseries.operationsdb;
import com.progresseries.db.*;
import java.sql.*;
import java.util.ArrayList;
public class GetUser {
	private static String url  = "jdbc:mysql://localhost/Progress";
	private static String dbLogin  = "root";
	private static String dbPassword  = "vvo200012312455";
	public static ArrayList<User> getUserByID (int insertiDUser) {
		ArrayList<User> users=new ArrayList<User>();
		String querry="SELECT * FROM User WHERE IDUser=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, dbLogin, dbPassword);
			try {
				PreparedStatement st=con.prepareStatement(querry);
				st.setInt(1, insertiDUser);
				ResultSet rs=st.executeQuery();
				while (rs.next()) {
					 int iDUser=rs.getInt(1);
					 String userName=rs.getString(2);
					 String userPassword=rs.getString(3);
					 int permission=rs.getInt(4);
					 User user=new User(iDUser, userName, userPassword, permission);
					 users.add(user);
					 
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
			System.out.println(users);

		}
		return users;
	}
	
	public static ArrayList<User> getUserByLogin (String insertLoginUser) {
		ArrayList<User> users=new ArrayList<User>();
		String querry="SELECT * FROM User WHERE UserName=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, dbLogin, dbPassword);
			try {
				PreparedStatement st=con.prepareStatement(querry);
				st.setString(1, insertLoginUser);
				ResultSet rs=st.executeQuery();
				while (rs.next()) {
					 int iDUser=rs.getInt(1);
					 String userName=rs.getString(2);
					 String userPassword=rs.getString(3);
					 int permission=rs.getInt(4);
					 User user=new User(iDUser, userName, userPassword, permission);
					 users.add(user);
					 
				}
				System.out.println(users.get(0).getUserName().toString());
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
			System.out.println(users);

		}
		return users;
	}
	
}
