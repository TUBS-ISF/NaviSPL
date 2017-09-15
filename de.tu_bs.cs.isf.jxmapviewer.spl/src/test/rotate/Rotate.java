package test.rotate;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import com.sun.javafx.geom.Point2D;

public class Rotate extends JMapViewer {
	
	public double rotAngle = 45;
	
    public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
        AffineTransform transform = g2d.getTransform();
        transform.rotate(Math.toRadians(rotAngle), g2d.getClipBounds().getCenterX(), g2d.getClipBounds().getCenterX());
        g2d.setTransform(transform);
    	
        super.paintComponent(g);
    }
    
    public void moveMap(int x, int y) {
    	
    	Point2D p = new Point2D(x, y);    	
    	p = rotatePoint(p, rotAngle);
    	
        super.moveMap((int) p.x, (int) p.y);
    }
    
    public Point2D rotatePoint(Point2D p, double rot) {    	
    	Point2D r = new Point2D();
    	r.x = (float) (p.x * Math.cos(Math.toRadians(-rotAngle)) - p.y * Math.sin(Math.toRadians(-rotAngle)));
    	r.y = (float) (p.x * Math.sin(Math.toRadians(-rotAngle)) + p.y * Math.cos(Math.toRadians(-rotAngle)));    
    	return r;
    }

}
