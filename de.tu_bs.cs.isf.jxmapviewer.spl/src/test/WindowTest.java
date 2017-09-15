package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.JMapViewerTree;

public class WindowTest extends JFrame {

	private final JMapViewer mapViewer;

	public WindowTest() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mapViewer = new JMapViewer();

		setLayout(new BorderLayout());
		add(mapViewer, BorderLayout.CENTER);		 
		
		JPanel panel = new JPanel();
		JLabel menuLabel = new JLabel("MENU");
		JLabel asdfLabel = new JLabel("asdfasdfasdf");
	    
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
	    panel.setMinimumSize(new Dimension(200, 200));
		
		panel.add(menuLabel);
		panel.add(asdfLabel);
		panel.add(new JLabel("DERP"));

		add(panel, BorderLayout.EAST);
		setVisible(true);
		setSize(1000, 1000);
	 }
	 
	 public static void main(String[] args) {
		 new WindowTest();
	 }
}
