package de.tu_bs.cs.isf.navi.gui;

import java.util.ArrayList;
import java.util.List;

import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.TileFactoryInfo;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class NavigationScene extends Application {

	public static int width = 1200;
	public static int height = 800;
	public static String version = "1.0.0";
	private JXMapKit jXMapKit;
	private List<TitledPane> titledPanes = new ArrayList<>();

	/**
	 * Starts the Scene
	 */
	@Override
	public void start(Stage rootStage) throws Exception {
		rootStage.setTitle("NavigationSystem " + version);
		Scene scene = new Scene(new BorderPane(), width, height);
		rootStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				rootStage.close();
				System.exit(0);
			}
		});

		BorderPane root = (BorderPane) scene.getRoot();
		setUpGUI(root);

		rootStage.setScene(scene);
		rootStage.show();
	}

	/**
	 * Fills BorderPane Should be only extended by setting TOP,LEFT,BOTTOM Pane
	 * 
	 * @param root
	 */
	private void setUpGUI(BorderPane root) {
		root.setCenter(setUpMap());
		root.setRight(setUpMenu());
	}

	/**
	 * Adds the map as node element Should not be changed by deltas
	 * 
	 * @return
	 */
	private SwingNode setUpMap() {
		SwingNode swingNode = new SwingNode();
		jXMapKit = new JXMapKit();

		jXMapKit.setMiniMapVisible(false);

		TileFactoryInfo info = new OSMTileFactoryInfo();
		DefaultTileFactory tileFactory = new DefaultTileFactory(info);
		jXMapKit.setTileFactory(tileFactory);

		swingNode.setContent(jXMapKit);
		return swingNode;
	}

	/**
	 * Adds the panes for menus Should be extended by deltas when adding gui elements 
	 * Requires: Adding TiltedPanes to titledPanes list before Super()
	 * 
	 * @return
	 */
	private Parent setUpMenu() {
		final Accordion accordion = new Accordion();
		accordion.setPrefWidth(width/4);
		accordion.getPanes().addAll(titledPanes);

		return accordion;
	}

}
