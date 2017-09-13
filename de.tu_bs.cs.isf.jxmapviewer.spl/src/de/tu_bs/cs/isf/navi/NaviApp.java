package de.tu_bs.cs.isf.navi;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import com.gg.slider.SideBar;
import com.gg.slider.SidebarSection;

import de.tu_bs.cs.isf.navi.routing.RoutingCalculator;
import de.tu_bs.cs.isf.navi.routing.RoutingInformation;

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

		for (String featureName : menuPanelList.keySet()) {
			menuPanel.add(new SidebarSection(menuPanel, featureName, menuPanelList.get(featureName)));
		}
	}

	public void addMenu1() {
		int q = 25;
		Insets i = new Insets(q, q, q, q);
		
		final JTextField startLatitude = new JTextField();
		startLatitude.setText("8.34234");
		final JTextField startLongitude = new JTextField();
		startLongitude.setText("48.23424");		
		final JTextField endLatitude = new JTextField();
		endLatitude.setText("8.34423");
		final JTextField endLongitude = new JTextField();
		endLongitude.setText("48.26424");
		
		String[] test = {"Test", "Scroll"};
		final JList<String> list = new JList<String>(test);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);

		JButton startBtn = new JButton("Start Routing");
		startBtn.setMargin(i);
		startBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				RoutingCalculator calc = new RoutingCalculator(startLatitude.getText(), startLongitude.getText(),
						endLatitude.getText(), endLongitude.getText());
				routingInformation = calc.calculateRoute();
				if(routingInformation != null) {
					list.clearSelection();
					list.setListData(routingInformation.getRouteInstructions());
					paintRoute();
				}
			}

		});

		 JScrollPane listScroller = new JScrollPane(list);
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
		conStartBtn.gridwidth = 2;
		conStartBtn.fill = GridBagConstraints.HORIZONTAL;
		conStartBtn.gridx = 0;
		conStartBtn.gridy = 2;
		panel.add(startBtn, conStartBtn);

		GridBagConstraints conList = new GridBagConstraints();
		conList.gridwidth = 2;
		conList.fill = GridBagConstraints.HORIZONTAL;
		conList.gridx = 0;
		conList.gridy = 3;
		panel.add(listScroller, conList);

		menuPanelList.put("Routing", panel);
	}
	
	private void paintRoute() {
		// TODO
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
