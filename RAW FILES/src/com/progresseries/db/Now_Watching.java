package com.progresseries.db;
import java.io.Serializable;

public class Now_Watching implements Serializable {
	int iDEpisode;
	int iDTitle;
	int iDUser;
	private static final long serialVersionUID = 1L;
	public Now_Watching() {};
	public Now_Watching (int iDEpisode, int iDUser, int iDTitle) {
		this.iDEpisode=iDEpisode;
		this.iDTitle=iDTitle;
		this.iDUser=iDUser;
	}
	public int getiDEpisode() {
		return iDEpisode;
	}
	public void setiDEpisode(int iDEpisode) {
		this.iDEpisode = iDEpisode;
	}
	public int getiDTitle() {
		return iDTitle;
	}
	public void setiDTitle(int iDTitle) {
		this.iDTitle = iDTitle;
	}
	public int getiDUser() {
		return iDUser;
	}
	public void setiDUser(int iDUser) {
		this.iDUser = iDUser;
	}
	
}
