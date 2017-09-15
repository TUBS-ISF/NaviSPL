/*package test;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.SwingUtilities;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.input.PanMouseInputListener;

public class PanMouseInputListenerRotate extends PanMouseInputListener {

	protected JXMapViewer viewer2;
	protected Point prev2;
	protected Cursor priorCursor2;

	public PanMouseInputListenerRotate(JXMapViewer viewer) {
		super(viewer);
		viewer2 = viewer;
	}

	@Override
	public void mousePressed(MouseEvent evt)
	{
		if (!SwingUtilities.isLeftMouseButton(evt))
			return;

		prev2 = evt.getPoint();
		priorCursor2 = viewer2.getCursor();
		viewer2.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
	}

	@Override
	public void mouseDragged(MouseEvent evt)
	{
		if (!SwingUtilities.isLeftMouseButton(evt))
			return;

		Point current = evt.getPoint();
		double x = viewer2.getCenter().getX();
		double y = viewer2.getCenter().getY();

		if(prev2 != null){
				x += prev2.x - current.x;
				y += prev2.y - current.y;
		}

		if (!viewer2.isNegativeYAllowed())
		{
			if (y < 0)
			{
				y = 0;
			}
		}

		int maxHeight = (int) (viewer2.getTileFactory().getMapSize(viewer2.getZoom()).getHeight() * viewer2
				.getTileFactory().getTileSize(viewer2.getZoom()));
		if (y > maxHeight)
		{
			y = maxHeight;
		}

		prev2 = current;
		viewer2.setCenter(new Point2D.Double(x, y));
		viewer2.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent evt)
	{
		if (!SwingUtilities.isLeftMouseButton(evt))
			return;

		prev2 = null;
		viewer2.setCursor(priorCursor2);
	}

}*/
