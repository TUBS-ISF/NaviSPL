package de.tu_bs.cs.isf.navi.rotation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

@SuppressWarnings("serial")
public class JMapViewerRotation extends JMapViewer {
	
	public double rotAngle = 45;
	
    public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        AffineTransform transform = g2d.getTransform();
        transform.rotate(Math.toRadians(rotAngle), g2d.getClipBounds().getCenterX(), g2d.getClipBounds().getCenterX());
        g2d.setTransform(transform);
    	
        super.paintComponent(g);
    }
    
    public void moveMap(int x, int y) {    	
    	Point p = new Point(x, y);    	
    	p = rotatePoint(p, rotAngle);
    	
        super.moveMap(p.x, p.y);
    }
    
    public ICoordinate getPosition(int mapPointX, int mapPointY) {
        int x = center.x + mapPointX - getWidth() / 2;
        int y = center.y + mapPointY - getHeight() / 2;

        Point p = new Point(x, y);
		p = rotatePoint(p, rotAngle, center);
        
        return tileSource.xyToLatLon(p.x, p.y, zoom);
    }
    
    public Point rotatePoint(Point p, double rot) {    	
    	Point r = new Point();
    	r.x = (int) (p.x * Math.cos(Math.toRadians(-rot)) - p.y * Math.sin(Math.toRadians(-rot)));
    	r.y = (int) (p.x * Math.sin(Math.toRadians(-rot)) + p.y * Math.cos(Math.toRadians(-rot))); 
    	
    	return r;
    }
    
    public Point rotatePoint(Point p, double rot, Point o) {    	
    	Point r = new Point();    	
    	r.x = (int) (((p.x - o.x) * Math.cos(Math.toRadians(-rot)) - (p.y - o.y) * Math.sin(Math.toRadians(-rot))) + o.x);
    	r.y = (int) (((p.x - o.x) * Math.sin(Math.toRadians(-rot)) + (p.y - o.y) * Math.cos(Math.toRadians(-rot))) + o.y);
		    	
    	return r;
		
    }
    

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // In delta, recalculate the visible border ( * 2 )
        /*
         int xMin = -tilesize * 2;
         int yMin = -tilesize * 2;
         int xMax = getWidth() * 2;
         int yMax = getHeight() * 2;
        */
    }
    
}
