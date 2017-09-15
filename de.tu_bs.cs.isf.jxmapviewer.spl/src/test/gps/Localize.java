package test.gps;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

import de.tu_bs.cs.isf.navi.NaviApp;

public class Localize extends NaviApp {
	
	private static final long serialVersionUID = -321905812724383307L;
	private JTextField GPSlat, GPSlon;
	
	private MapMarkerDot GPSselect;
	
	private JPanel addGPS() {
		JPanel gpsMenu = new JPanel();
		gpsMenu.setLayout(new GridBagLayout());
		
		GridBagConstraints bagCon = new GridBagConstraints();
		
		JLabel latLab = new JLabel("Lat: ");
		bagCon.fill = GridBagConstraints.HORIZONTAL;
		bagCon.gridx = 0;
		bagCon.gridy = 0;
		bagCon.weightx = 1;
		gpsMenu.add(latLab, bagCon);
		
		GPSlat = new JTextField();
		bagCon.fill = GridBagConstraints.HORIZONTAL;
		bagCon.gridx = 1;
		bagCon.gridy = 0;
		bagCon.weightx = 3;
		gpsMenu.add(GPSlat, bagCon);
		
		JLabel lonLab = new JLabel("Lon: ");
		bagCon.fill = GridBagConstraints.HORIZONTAL;
		bagCon.gridx = 0;
		bagCon.gridy = 1;
		bagCon.weightx = 1;
		gpsMenu.add(lonLab, bagCon);		
		
		GPSlon = new JTextField();
		bagCon.fill = GridBagConstraints.HORIZONTAL;
		bagCon.gridx = 1;
		bagCon.gridy = 1;
		bagCon.weightx = 3;
		gpsMenu.add(GPSlon, bagCon);
					
		JButton gpsButton = new JButton();
		gpsButton.setText("Go To Location");
		bagCon.fill = GridBagConstraints.HORIZONTAL;
		bagCon.gridx = 1;
		bagCon.gridy = 2;
		bagCon.weightx = 2;
		gpsMenu.add(gpsButton, bagCon);
		
		gpsButton.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				try {
			    	double lat = Double.valueOf(GPSlat.getText());
			    	double lon = Double.valueOf(GPSlon.getText());
			    	Coordinate co = new Coordinate(lat, lon);
			        mapViewer.setDisplayPosition(co, mapViewer.getZoom());;
		    	} catch (NumberFormatException e1) {
		    		
		    	}
			}

			public void mousePressed(MouseEvent e) { }

			public void mouseReleased(MouseEvent e) { }

			public void mouseEntered(MouseEvent e) { }

			public void mouseExited(MouseEvent e) { }
			
		});
		
		mapViewer.addMouseListener(new MouseListener() {	
			
			public void mouseClicked(MouseEvent e) {
		        
		        Point point = e.getPoint();
		        Coordinate co = (Coordinate) mapViewer.getPosition(point);

				GPSlat.setText(String.valueOf(co.getLat()));
				GPSlon.setText(String.valueOf(co.getLon()));
				
				if (GPSselect == null) {
					GPSselect = new MapMarkerDot(co);
					mapViewer.addMapMarker(GPSselect);
				} else {
					GPSselect.setLat(co.getLat());
					GPSselect.setLon(co.getLon());
					mapViewer.repaint();
				}
				
			}	
			
			public void mousePressed(java.awt.event.MouseEvent e) {	}

			
			public void mouseReleased(java.awt.event.MouseEvent e) { }

			
			public void mouseEntered(java.awt.event.MouseEvent e) {	 }

			
			public void mouseExited(java.awt.event.MouseEvent e) {	 }
        });
		
		return gpsMenu;
	}
	
	public void addMenu2() {
		menuPanelList.put("GPS", addGPS());
	}
	
	public static void main(String[] args) {
		new Localize();
	}
	
}
