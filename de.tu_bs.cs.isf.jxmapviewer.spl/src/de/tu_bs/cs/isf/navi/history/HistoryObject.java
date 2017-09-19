package de.tu_bs.cs.isf.navi.history;

public class HistoryObject {

	long timestamp;
	double startlongitude;
	double startlatitude;
	double endLongitude;
	double endlatitude;
	
	public HistoryObject (double startlongitude, double startlatitude, double endlongitude, double endlatitude) {
		
		this.startlongitude = startlongitude;
		this.startlatitude = startlatitude;
		this.endLongitude = endlongitude;
		this.endlatitude = endlatitude;
		timestamp= System.currentTimeMillis();
	}
	
	public HistoryObject (double startlongitude, double startlatitude) {
		
		this.startlongitude = startlongitude;
		this.startlatitude = startlatitude;
		timestamp= System.currentTimeMillis();
	}

	public double getStartlongitude() {
		return startlongitude;
	}

	public void setStartlongitude(double startlongitude) {
		this.startlongitude = startlongitude;
	}

	public double getStartlatitude() {
		return startlatitude;
	}

	public void setStartlatitude(double startlatitude) {
		this.startlatitude = startlatitude;
	}

	public double getEndLongitude() {
		return endLongitude;
	}

	public void setEndLongitude(double endLongitude) {
		this.endLongitude = endLongitude;
	}

	public double getEndlatitude() {
		return endlatitude;
	}

	public void setEndlatitude(double endlatitude) {
		this.endlatitude = endlatitude;
	}

	public long getTimestamp() {
		return timestamp;
	}
	
	
	
}
