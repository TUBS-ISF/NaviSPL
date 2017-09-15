/*package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.GeoPosition;

public class JXMapViewerRotate extends JXMapViewer {

	private static final long serialVersionUID = 1L;
	
	protected double rotateAngle;
	
	public void setRotateAngle(double angle) {
		rotateAngle = angle;
	}
	
	public double getRotateAngle() {
		return rotateAngle;
	}
	
	@Override
    public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        AffineTransform transform = g2d.getTransform();
        transform.rotate(Math.toRadians(getRotateAngle()), g2d.getClipBounds().getCenterX(), g2d.getClipBounds().getCenterX());
        g2d.setTransform(transform);
        
		super.paint(g);
    }
	
	@Override
	public Point2D convertGeoPositionToPoint(GeoPosition pos) {
		// convert from geo to world bitmap
		Point2D pt = getTileFactory().geoToPixel(pos, getZoom());
		// convert from world bitmap to local
		Rectangle bounds = getViewportBounds();
		
		Point2D pt2 = new Point2D.Double(pt.getX() - bounds.getX(), pt.getY() - bounds.getY());
		return rotatePoint(pt2, getRotateAngle());
	}

	@Override
	public GeoPosition convertPointToGeoPosition(Point2D pt) {
		// convert from local to world bitmap
		Rectangle bounds = getViewportBounds();
		Point2D pt2 = new Point2D.Double(pt.getX() + bounds.getX(), pt.getY() + bounds.getY());
		
		// rotate back
		rotatePoint(pt2, -getRotateAngle());
	
		// convert from world bitmap to geo
		GeoPosition pos = getTileFactory().pixelToGeo(pt2, getZoom());
		return pos;
	}
	
	public Point2D rotatePoint(Point2D pt, double angle) {

		double centerX = getViewportBounds().getCenterX();
		double centerY = getViewportBounds().getCenterX();		
		double newX = centerX + (pt.getX()-centerX)*Math.cos(angle) - (pt.getY()-centerY)*Math.sin(angle);
		double newY = centerY + (pt.getX()-centerX)*Math.sin(angle) + (pt.getY()-centerY)*Math.cos(angle);
		//pt.setLocation(newX, newY);
		return pt;
	}

}*/
