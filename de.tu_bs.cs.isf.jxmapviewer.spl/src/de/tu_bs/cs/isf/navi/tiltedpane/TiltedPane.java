package de.tu_bs.cs.isf.navi.tiltedpane;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class TiltedPane extends JPanel {

	private static final long serialVersionUID = -2545231447111288534L;

	private int titleHeight = 30;

	private JLabel titlePanel;
	private JComponent contentPane;

	private int minComponentWidth;

	private int prefHeight = 0;

	private TiltedPaneBar tiltedPaneBar;

	private boolean firstCalculationHeight = true;

	public TiltedPane(TiltedPaneBar tiltedPaneBar, String text, JComponent component) {
		setLayout(new BorderLayout());

		this.tiltedPaneBar = tiltedPaneBar;
		this.contentPane = component;
		this.minComponentWidth = tiltedPaneBar.getPreferredSize().width;
		calculateHeight();
		
		
		titlePanel = new JLabel(text);
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setPreferredSize(new Dimension(getPreferredSize().width, titleHeight));
		titlePanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		titlePanel.setPreferredSize(new Dimension(minComponentWidth, titleHeight));
		titlePanel.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if (isCollapsed()) {
					expand();
				} else {
					collapse();
				}
			}
		});
		
		add(titlePanel, BorderLayout.NORTH);
		add(component, BorderLayout.CENTER);

		invalidate();
	}

	private void calculateHeight() {
		if (firstCalculationHeight || contentPane.isVisible()) {
			prefHeight = titleHeight*2;
			for (Component c : contentPane.getComponents()) {
				prefHeight += c.getPreferredSize().height;
			}
			firstCalculationHeight = false;
		}
		if (!contentPane.isVisible()) {
			prefHeight = titleHeight;
		}
	}

	public void collapse() {
		contentPane.setVisible(false);
		calculateHeight();
		contentPane.setPreferredSize(new Dimension(minComponentWidth, prefHeight));
		tiltedPaneBar.invalidate();
	}

	public void expand() {
		contentPane.setVisible(true);
		calculateHeight();
		contentPane.setPreferredSize(new Dimension(minComponentWidth, prefHeight));
		tiltedPaneBar.invalidate();
	}

	public boolean isCollapsed() {
		return !contentPane.isVisible();
	}

	@Override
	public Dimension getMinimumSize() {
		calculateHeight();
		return new Dimension(minComponentWidth, prefHeight);
	}

	@Override
	public Dimension getPreferredSize() {
		calculateHeight();
		return new Dimension(minComponentWidth, prefHeight);
	}

}
