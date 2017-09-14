package de.tu_bs.cs.isf.navi.gui;

import java.io.Serializable;

import org.openstreetmap.gui.jmapviewer.Coordinate;

public class FavoriteListElement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double lat;
	private double longi;
	private String name;

	public FavoriteListElement(String name, double lat, double longi){
		setLat(lat);
		setLongi(longi);
		this.setName(name);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLat() {
		return lat;
	}


	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getLongi() {
		return longi;
	}


	public void setLongi(double longi) {
		this.longi = longi;
	}


	public String toString() {
		return this.getName();
	}

}
