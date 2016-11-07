// This entire file is part of my masterpiece.
// Lucy Zhang

package View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

/**
 * This class oversees the entire IDE and holds all of the workspaces
 * @author lucyzhang
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
	 * Initializes the entire slogo view scene that holds all of the workspaces
	 * @return
	 */
	public Scene init() {
		initScene();
		createNewWorkSpace();
		return myScene;
	}

	/**
	 * 
	 * @return the list of workspaces
	 */
	public ArrayList<Workspace> getWorkspaces() {
		return workspaces;
	}

	/**
	 * Sets the background color
	 * @param color
	 */
	public void setBackgroundColor(String color) {
		this.backgroundColor = color;
	}
	
	/**
	 * 
	 * @return the scene
	 */
	public Scene getScene() {
		return myScene;
	}

	/**
	 * 
	 * @return the main tabpane view
	 */
	public TabPane getMainView() {
		return mainView;
	}

	/**
	 * Get the current workspace that the user is on
	 * @return the current workspace
	 */
	public Workspace getCurrentWorkspace() {
		Tab currentTab = mainView.getSelectionModel().getSelectedItem();
		int wkspcID = Integer.parseInt(String.valueOf(currentTab.getText().charAt(0))) - 1;
		return workspaces.get(wkspcID);
	}
	
	/**
	 * Create a new workspace for the slogo view
	 */
	public void createNewWorkSpace() {
		numWorkspaces++;
		Tab tab = new Tab();
		addTitleToWorkspace(tab);
		tab.setContent(initWorkspace().getMyRoot());
		mainView.getTabs().add(tab);
		getCurrentWorkspace().selectLanguageThroughUI(language);

	}
	
	/**
	 * Parse the workspace data for key settings
	 * @return a map of the data. 
	 */
	public Map<String, String> parseWorkspaceData() {
		String title = getCurrentWorkspaceTitle();
		Map<String, String> data = new HashMap<String, String>();
		data.put("title", title);
		data.put("background_color", backgroundColor);
		data.put("language", getCurrentWorkspace().getCurrentLanguage());
		data.put("numTurtles", Integer.toString(getCurrentWorkspace().getNumTurtles()));
		return data;
	}

	private String getCurrentWorkspaceTitle() {
		Tab currentTab = mainView.getSelectionModel().getSelectedItem();
		return currentTab.getText();
	}

	private void initScene() {
		myScene = new Scene(mainView, SCENE_WIDTH, SCENE_HEIGHT, Color.WHITE);
	}

	private Workspace initWorkspace() {
		Workspace slogo=constructWorkspace();
		updateLanguage(slogo);
		workspaces.add(slogo);
		slogo.init(this);
		return slogo;
	}

	private void addTitleToWorkspace(Tab tab) {
		if (stringExists(title)) {
			tab.setText(numWorkspaces + ": " + title);
		} else {
			tab.setText(Integer.toString(numWorkspaces));
		}

	}
	
	private Workspace constructWorkspace(){
		Workspace slogo;
		if (stringExists(backgroundColor)) {
			slogo = new Workspace(numWorkspaces, backgroundColor);
		} else {
			slogo = new Workspace(numWorkspaces);
		}
		return slogo;
	}
	
	private void updateLanguage(Workspace slogo){
		if (stringExists(language)) {
			slogo.setResources(ResourceBundle.getBundle(LANGUAGEPATH + language));
		}
	}

	private boolean stringExists(String text) {
		return (text != null && !text.isEmpty());
	}


}
