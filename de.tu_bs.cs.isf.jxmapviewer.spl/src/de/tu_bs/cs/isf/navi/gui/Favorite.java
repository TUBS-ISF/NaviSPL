package de.tu_bs.cs.isf.navi.gui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;

public class Favorite extends TitledPane implements Serializable{
	
	ObservableList<String> content = FXCollections.observableArrayList();
	
	/**
	 * Constructor for a new Favorite List Object. extends TitledPane.
	 * Sets its Title as "Favorite" and loads previous entries into the favorite list from file.
	 */
	public Favorite() {
		loadFavListState();
		this.setContent(createFavBorderPane());
		this.setText("Favorites");
	}
	
	/**
	 * Creates the BorderPane layout inside the TitledPane that contains the favorite entries.
	 * @return borderPane
	 */
	private BorderPane createFavBorderPane () {
		BorderPane borderPane = new BorderPane();
		ListView<String> favList= new ListView<String>(content);
		borderPane.setCenter(favList);
		return borderPane;
	}
		
	/**
	 * Adds an entry into the list of favorites.
	 * @param element
	 */
	public void addFavListElement(String element) {
		content.add(element);
		saveFavListState();
	}
	
	/**
	 * removes specified entry from favorite list. 
	 * @param element
	 */
	public void removeFavListElement(String element) {
		content.remove(element);
		saveFavListState();
	}
	
	/**
	 * Saves the current favorite list to file
	 */
	private void saveFavListState() {
		try {
			FileOutputStream fileOutput = new FileOutputStream("src/de/tu_bs/cs/isf/navi/gui/favList");
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			ArrayList<String> tempList = new ArrayList<String>(content);
			objectOutput.writeObject(tempList);
			fileOutput.close();
			objectOutput.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *Loads entries from favorite save file, if possible.
	 */
	private void loadFavListState() {
		try {
			FileInputStream inputStream = new FileInputStream("src/de/tu_bs/cs/isf/navi/gui/favList");			
			ObjectInputStream objectInput = new ObjectInputStream(inputStream);
			List<String> tempList = (List<String>) (objectInput.readObject());
			this.content = FXCollections.observableArrayList(tempList);
			inputStream.close();
			objectInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
