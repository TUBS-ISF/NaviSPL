package de.tu_bs.cs.isf.navi.tiltedpane;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

public class TiltedPaneBar extends JScrollPane{
	
	private static final long serialVersionUID = -8533367844602412085L;
	private ScrollPaneLayout layout = new ScrollPaneLayout();
	private JPanel components = new JPanel();
	private int i = 0;
	
	public TiltedPaneBar() {
		
		setLayout(layout);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setFocusable(false);
		setViewportView(components);
		
		GridBagLayout gbl = new GridBagLayout();
		components.setLayout(gbl);
		
		invalidate();
	}
	
	public void addSection(TiltedPane section, boolean collapsed) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = i++;
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		components.add(section, gbc);
		if (collapsed) section.collapse();
		invalidate();
	}

	
}
