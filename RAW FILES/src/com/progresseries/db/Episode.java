package com.progresseries.db;
import java.io.Serializable;

public class Episode implements Serializable {
	int iDEpisode;
	String name;
	String description;
	double length;
	int iDTitle;
	private static final long serialVersionUID = 1L;
	public Episode () {};
	public Episode (String name, String description, double length, int iDTitle) {
		this.name=name;
		this.description=description;
		this.length=length;
		this.iDTitle=iDTitle;
	};

	public Episode (int iDEpisode, String name, String description, double length, int iDTitle) {
		this.name=name;
		this.description=description;
		this.length=length;
		this.iDTitle=iDTitle;
		this.iDEpisode=iDEpisode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public int getiDTitle() {
		return iDTitle;
	}
	public void setiDTitle(int iDTitle) {
		this.iDTitle = iDTitle;
	}
	public int getiDEpisode() {
		return iDEpisode;
	};
}
