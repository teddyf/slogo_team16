package View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * The main slogo view class. This class holds all of the workspaces and acts as
 * the overseer of all of the slogo IDE.
 * 
 * @author Lucy Zhang
 * @author Jordan Frazier
 *
 */
public class SlogoView {

	public static final int SCENE_WIDTH = 1200;
	public static final int SCENE_HEIGHT = 700;
	public static final String LANGUAGEPATH = "resources/languages/";

	private TabPane mainView = new TabPane();
	private Scene myScene;
	private int numWorkspaces;
	private ArrayList<Workspace> workspaces = new ArrayList<Workspace>();
	private String title;
	private String backgroundColor;
	private String language;

	public SlogoView() {
		numWorkspaces = 0;
		mainView = new TabPane();
	}

	public SlogoView(String title, String backgroundColor, String language, int numTurtles) {
		this.title = title;
		this.backgroundColor = backgroundColor;
		this.language = language;
		numWorkspaces = 0;
		mainView = new TabPane();
	}

	/**
	 * Initializes the scene
	 * 
	 * @return the scene
	 */
	public Scene init() {
		initScene();
		createNewWorkSpace();
		return myScene;
	}

	public ArrayList<Workspace> getWorkspaces() {
		return workspaces;
	}

	public void setBackgroundColor(String color) {
		this.backgroundColor = color;
	}

	/*
	 * Gets the current workspace
	 */
	public Workspace getCurrentWorkspace() {
		Tab currentTab = mainView.getSelectionModel().getSelectedItem();
		int wkspcID = Integer.parseInt(String.valueOf(currentTab.getText().charAt(0))) - 1;
		return workspaces.get(wkspcID);
	}

	private void setCurrentWorkspaceTitle() {
		Tab currentTab = mainView.getSelectionModel().getSelectedItem();
		title = currentTab.getText();
	}

	private void initScene() {
		myScene = new Scene(mainView, SCENE_WIDTH, SCENE_HEIGHT, Color.WHITE);
	}

	/**
	 * Create a new workspace
	 */
	public void createNewWorkSpace() {
		numWorkspaces++;
		Tab tab = new Tab();
		if (stringExists(title)) {
			tab.setText(numWorkspaces + ": " + title);
		} else {
			tab.setText(Integer.toString(numWorkspaces));
		}
		tab.setContent(initWorkspace().getMyRoot());
		mainView.getTabs().add(tab);
		getCurrentWorkspace().selectLanguageThroughUI(language);

	}
	

	/*
	 * Initializes the workspace by adding it to the slogo view
	 */
	private Workspace initWorkspace() {
		Workspace slogo;
		if (stringExists(backgroundColor)) {
			slogo = new Workspace(numWorkspaces, backgroundColor);
		} else {
			slogo = new Workspace(numWorkspaces);
		}
		if (stringExists(language)) {
			slogo.setResources(ResourceBundle.getBundle(LANGUAGEPATH + language));
		}
		workspaces.add(slogo);
		slogo.init(this);
		return slogo;
	}

	/**
	 * Parse the workspace data
	 * 
	 * @return the map of workspace data
	 */
	public Map<String, String> parseWorkspaceData() {
		setCurrentWorkspaceTitle();
		Map<String, String> data = new HashMap<String, String>();
		data.put("title", title);
		data.put("background_color", backgroundColor);
		data.put("language", getCurrentWorkspace().getCurrentLanguage());
		data.put("numTurtles", Integer.toString(getCurrentWorkspace().getNumTurtles()));
		return data;
	}

	private boolean stringExists(String text) {
		return (text != null && !text.isEmpty());
	}

	public Scene getScene() {
		return myScene;
	}

	public TabPane getMainView() {
		return mainView;
	}

}
