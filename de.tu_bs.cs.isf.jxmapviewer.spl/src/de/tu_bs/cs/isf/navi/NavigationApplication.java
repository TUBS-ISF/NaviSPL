package de.tu_bs.cs.isf.navi;

import de.tu_bs.cs.isf.navi.gui.NavigationScene;

public class NavigationApplication {

	/**
	 * Starts the application
	 * @param args
	 */
	public static void main(String[] args) {
		 new Thread() {
	            @Override
	            public void run() {
	                javafx.application.Application.launch(NavigationScene.class);
	            }
	        }.start();
		
	}

}
