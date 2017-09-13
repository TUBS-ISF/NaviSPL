package de.tu_bs.cs.isf.navi;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.Layer;

import com.gg.slider.SideBar;
import com.gg.slider.SidebarSection;




/* ROUTING */
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;

import de.tu_bs.cs.isf.navi.routing.RoutingCalculator;
import de.tu_bs.cs.isf.navi.routing.RoutingCoordinate;
import de.tu_bs.cs.isf.navi.routing.RoutingInformation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JPanel;



import com.gg.slider.SideBar.SideBarMode;

@SuppressWarnings("serial")
public class NaviApp extends JFrame {

	private JMapViewer mapViewer;

	private SideBar menuPanel;

	private JSplitPane splitPane;

	private HashMap<String, JComponent> menuPanelList;

	private int width = 1200;

	private int height = 1000;

	private static final String VERSION = "1.0.0";
	
	/**
	 * Routing
	 */
	private RoutingInformation routingInformation;

	public NaviApp() {
		super("Navigation System " + VERSION);
		
		setupWindow();
		setupGUI();

		setVisible(true);
	}

	public void setupWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation((this.getWidth() / 4) * 3);

		setLayout(new GridBagLayout());

		GridBagConstraints constr = new GridBagConstraints();
		constr.fill = GridBagConstraints.BOTH;
		constr.gridx = 0;
		constr.gridy = 0;
		constr.weightx = 1;
		constr.weighty = 1;

		getContentPane().add(splitPane, constr);

	}

	public void setupGUI() {
		setupMap();
		setupMenu();
	}

	public void setupMap() {
		mapViewer = new JMapViewer();
		mapViewer.setMinimumSize(new Dimension(0, 0));
		splitPane.setLeftComponent(mapViewer);
	}

	public void setupMenu() {

		menuPanel = new SideBar(SideBarMode.TOP_LEVEL, true, 300, true);
		menuPanel.setMinimumSize(new Dimension(0, 0));
		splitPane.setRightComponent(menuPanel);

		menuPanelList = new HashMap<String, JComponent>();

		// Call menu functionsconSartCoordBtn
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

		for (String featureName : menuPanelList.keySet()) {
			menuPanel.add(new SidebarSection(menuPanel, featureName, menuPanelList.get(featureName)));
		}
	}

	public void addMenu1() {
		int q = 25;
		Insets i = new Insets(q, q, q, q);

		
		final JTextField startLatitude = new JTextField();
		startLatitude.setText("52.280817");
		final JTextField startLongitude = new JTextField();
		startLongitude.setText("10.518804");
		JButton getStartCoords = new JButton("GetStart");
		getStartCoords.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
//				MapMarkerDot m = GPSselect;
//				startLatitude.setText(String.valueOf(m.getLat()));
//				startLongitude.setText(String.valueOf(m.getLon()));
			}
			
		});
				
		final JTextField endLatitude = new JTextField();
		endLatitude.setText("52.248309");
		final JTextField endLongitude = new JTextField();
		endLongitude.setText("10.531181");
		JButton getEndCoords = new JButton("GetEnd");
		getEndCoords.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
//				MapMarkerDot m = GPSselect;
//				endLatitude.setText(String.valueOf(m.getLat()));
//				endLongitude.setText(String.valueOf(m.getLon()));
			}
			
		});
		
		
		String[] test = {"Test", "Scroll"};
		final JList<String> routingList = new JList<String>(test);
		routingList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		routingList.setLayoutOrientation(JList.VERTICAL);
		routingList.setVisibleRowCount(-1);

		JButton startBtn = new JButton("Start Routing");
		startBtn.setMargin(i);
		startBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				RoutingCalculator calc = new RoutingCalculator(startLatitude.getText(), startLongitude.getText(),
						endLatitude.getText(), endLongitude.getText());
				routingInformation = calc.calculateRoute();
				if(routingInformation != null) {
					routingList.clearSelection();
					routingList.setListData(routingInformation.getRouteInstructions());
					paintRoute();
				} else {
					String[] gehtNicht = new String[] {"Route kann nicht berechnet werden"};
					routingList.setListData(gehtNicht);
				}
			}

		});

		 JScrollPane listScroller = new JScrollPane(routingList);
		 listScroller.setPreferredSize(new Dimension(250, 250));

		// Layout
		JPanel panel = new JPanel();
		GridBagLayout grid = new GridBagLayout();

		panel.setLayout(grid);

		GridBagConstraints conStartLat = new GridBagConstraints();
		conStartLat.weightx = 1;
		conStartLat.fill = GridBagConstraints.HORIZONTAL;
		conStartLat.gridx = 0;
		conStartLat.gridy = 0;
		panel.add(startLatitude, conStartLat);

		GridBagConstraints conStartLong = new GridBagConstraints();
		conStartLong.weightx = 1;
		conStartLong.fill = GridBagConstraints.HORIZONTAL;
		conStartLong.gridx = 1;
		conStartLong.gridy = 0;
		panel.add(startLongitude, conStartLong);

		GridBagConstraints conEndLat = new GridBagConstraints();
		conEndLat.weightx = 1;
		conEndLat.fill = GridBagConstraints.HORIZONTAL;
		conEndLat.gridx = 0;
		conEndLat.gridy = 1;
		panel.add(endLatitude, conEndLat);

		GridBagConstraints conEndLong = new GridBagConstraints();
		conEndLong.weightx = 1;
		conEndLong.fill = GridBagConstraints.HORIZONTAL;
		conEndLong.gridx = 1;
		conEndLong.gridy = 1;
		panel.add(endLongitude, conEndLong);

		GridBagConstraints conStartBtn = new GridBagConstraints();
		conStartBtn.gridwidth = 3;
		conStartBtn.fill = GridBagConstraints.HORIZONTAL;
		conStartBtn.gridx = 0;
		conStartBtn.gridy = 2;
		panel.add(startBtn, conStartBtn);

		GridBagConstraints conList = new GridBagConstraints();
		conList.gridwidth = 3;
		conList.fill = GridBagConstraints.HORIZONTAL;
		conList.gridx = 0;
		conList.gridy = 3;
		panel.add(listScroller, conList);
		
		GridBagConstraints conSartCoordBtn = new GridBagConstraints();
		conSartCoordBtn.fill = GridBagConstraints.HORIZONTAL;
		conSartCoordBtn.gridx = 2;
		conSartCoordBtn.gridy = 0;
		panel.add(getStartCoords, conSartCoordBtn);
		
		GridBagConstraints conEndCoordBtn = new GridBagConstraints();
		conEndCoordBtn.fill = GridBagConstraints.HORIZONTAL;
		conEndCoordBtn.gridx = 2;
		conEndCoordBtn.gridy = 1;
		panel.add(getEndCoords, conEndCoordBtn);
		
		menuPanelList.put("Routing", panel);
	}
	
	private MapPolygon readyPolygon;
	private void paintRoute() {		
		if (routingInformation.getRoutingInformation().size() <= 1)
			return;
		List<double[]> polygon = routingInformation.getPolygonPoints();
		RoutingCoordinate[] way = new RoutingCoordinate[polygon.size() * 2];
		for (int i = 0; i < polygon.size(); i++) {
			way[i] = new RoutingCoordinate(polygon.get(i)[0], polygon.get(i)[1]);
		}
		for (int i = polygon.size() - 1; i >= 0; i--) {
			way[polygon.size() * 2 - i - 1] = new RoutingCoordinate(polygon.get(i)[0], polygon.get(i)[1]);
		}
		
		mapViewer.removeMapPolygon(readyPolygon);
		readyPolygon = new MapPolygonImpl(way);
		mapViewer.addMapPolygon(readyPolygon);
		mapViewer.repaint();
	}

	public void addMenu2() {
	}

	public void addMenu3() {
	}

	public void addMenu4() {
	}

	public void addMenu5() {
	}

	public void addMenu6() {
	}

	public void addMenu7() {
	}

	public void addMenu8() {
	}

	public void addMenu9() {
	}

	public void addMenu10() {
	}

	public void addMenu11() {
	}

	public void addMenu12() {
	}

	public void addMenu13() {
	}

	public void addMenu14() {
	}

	public void addMenu15() {
	}

	public static void main(String[] args) {
		new NaviApp();
	}
}
