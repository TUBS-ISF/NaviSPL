package de.tu_bs.cs.isf.navi;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import test.WindowTest;

public class NaviApp extends JFrame {

	private static final long serialVersionUID = 7703210673451235840L;
	private JMapViewer mapViewer;
	
	private JPanel menuPanel;
	
	private List<JPanel> menuPanelList;

	public NaviApp() {
		super("Navi");
		
		setupWindow();
		setupGUI();

		setVisible(true);
	}
	
	public void setupWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); 

		setSize(1000, 1000);
	}
	
	public void setupGUI() {
		setupMap();
		setupMenu();
	}
	
	public void setupMap() {
		mapViewer = new JMapViewer();
		add(mapViewer, BorderLayout.CENTER);
	}
	
	public void setupMenu() {
		
		menuPanel = new JPanel();
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));
		getContentPane().add(menuPanel, BorderLayout.EAST);

		JLabel menuLabel = new JLabel("-- MENU --");		
	    menuPanel.add(menuLabel);		
		
		menuPanelList = new ArrayList<JPanel>();
		
		// Call menu functions
		addMenu1();
		addMenu2();
		addMenu3();
		addMenu4();
		addMenu5();
		addMenu6();
		addMenu7();
		addMenu8();
		addMenu9();
		addMenu10();
		addMenu11();
		addMenu12();
		addMenu13();
		addMenu14();
		addMenu15();		
		
		for (JPanel p : menuPanelList) {
			menuPanel.add(p);
		}
	}

	public void addMenu1() {}
	public void addMenu2() {}
	public void addMenu3() {}
	public void addMenu4() {}
	public void addMenu5() {}
	public void addMenu6() {}
	public void addMenu7() {}
	public void addMenu8() {}
	public void addMenu9() {}
	public void addMenu10() {}
	public void addMenu11() {}
	public void addMenu12() {}
	public void addMenu13() {}
	public void addMenu14() {}
	public void addMenu15() {}
	 
	public static void main(String[] args) {
		new NaviApp();
	}
}
