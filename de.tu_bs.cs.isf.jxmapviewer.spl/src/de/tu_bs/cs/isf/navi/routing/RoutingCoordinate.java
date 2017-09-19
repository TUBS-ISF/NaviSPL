package de.tu_bs.cs.isf.navi.routing;

import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

public class RoutingCoordinate implements ICoordinate {
	
	private double lat;
	private double longi;
	
	public RoutingCoordinate(double lat, double longi) {
		this.setLat(lat);
		this.setLon(longi);
	}
	
	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return longi;
	}

	public void setLon(double lon) {
		this.longi = lon;
	}

}
