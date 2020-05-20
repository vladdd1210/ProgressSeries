package com.progresseries.db;
import java.io.Serializable;

public class User  implements Serializable {
 int iDUser;
 String userName;
 String userPassword;
 int permission;
	private static final long serialVersionUID = 1L;
	public User () {};
	public User (String userName, String userPassword, int permission) {
		this.userName=userName;
		this.userPassword=userPassword;
		this.permission=permission;
	};
	
	public User ( int iDUser,  String userName, String userPassword, int permission) {
		this.iDUser=iDUser;
		this.userName=userName;
		this.userPassword=userPassword;
		this.permission=permission;
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getiDUser() {
		return iDUser;
	};
	
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	
}
