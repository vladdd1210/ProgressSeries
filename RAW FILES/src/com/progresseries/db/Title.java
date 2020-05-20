package com.progresseries.db;
import java.io.Serializable;

public class Title implements Serializable {
	private int iDTitle;
	private String name;
	private String description;
	private static final long serialVersionUID = 1L;
	public Title () {};
	public Title (String name, String description) {
		this.name=name;
		this.description=description;
	};
	public Title (int iDTitle, String name, String description) {
		this.name=name;
		this.description=description;
		this.iDTitle=iDTitle;
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
	public int getiDTitle() {
		return iDTitle;
	};
}
