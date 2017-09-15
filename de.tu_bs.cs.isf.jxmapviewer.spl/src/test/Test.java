/*package test;

import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

import sample3_interaction.SelectionAdapter;
import sample3_interaction.SelectionPainter;

public class Test {

	public static void main(String[] args) {

		JXMapViewerRotate mapViewer = new JXMapViewerRotate();

		// Create a TileFactoryInfo for OpenStreetMap
		TileFactoryInfo info = new OSMTileFactoryInfo();
		DefaultTileFactory tileFactory = new DefaultTileFactory(info);
		mapViewer.setTileFactory(tileFactory);

		// Use 8 threads in parallel to load the tiles
		tileFactory.setThreadPoolSize(8);

		// Set the focus
		GeoPosition frankfurt = new GeoPosition(50.11, 8.68);

		mapViewer.setZoom(7);
		mapViewer.setAddressLocation(frankfurt);

		mapViewer.setRotateAngle(45);

		// Add interactions
		MouseInputListener mia = new PanMouseInputListener(mapViewer);
		mapViewer.addMouseListener(mia);
		mapViewer.addMouseMotionListener(mia);

		mapViewer.addMouseListener(new CenterMapListener(mapViewer));

		mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));

		mapViewer.addKeyListener(new PanKeyListener(mapViewer));

		// Add a selection painter
		SelectionAdapter sa = new SelectionAdapter(mapViewer);
		SelectionPainter sp = new SelectionPainter(sa);
		mapViewer.addMouseListener(sa);
		mapViewer.addMouseMotionListener(sa);
		mapViewer.setOverlayPainter(sp);

		// Display the viewer in a JFrame
		JFrame frame = new JFrame("Test");
		frame.getContentPane().add(mapViewer);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}*/
