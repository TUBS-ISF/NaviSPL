package de.tu_bs.cs.isf.navi;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import org.openstreetmap.gui.jmapviewer.JMapViewer;

import com.gg.slider.SideBar;
import com.gg.slider.SidebarSection;
import com.gg.slider.SideBar.SideBarMode;

@SuppressWarnings("serial")
public class NaviApp extends JFrame {

	protected JMapViewer mapViewer;
	
	private SideBar menuPanel;

	private JSplitPane splitPane;

	private HashMap<String, JComponent> menuPanelList;

	private int width = 1200;

	private int height = 1000;

	private static final String VERSION = "1.0.0";

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
		addMenu();

		for (String featureName : menuPanelList.keySet()) {
			menuPanel.add(new SidebarSection(menuPanel, featureName, menuPanelList.get(featureName)));
		}
	}

	public void addMenu() {
	}

	public static void main(String[] args) {
		new NaviApp();
	}
}
