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

	public SlogoView(String title, String backgroundColor, String language) {
		this.title = title;
		System.out.println("There is a title! 1st: " + this.title);
		this.backgroundColor = backgroundColor;
		this.language = language;
		numWorkspaces = 0;
		mainView = new TabPane();
	}

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

	public Workspace getCurrentWorkspaceLeftPane() {
		Tab currentTab = mainView.getSelectionModel().getSelectedItem();
		int wkspcID = Integer.parseInt(currentTab.getText()) - 1;
		return workspaces.get(wkspcID);
	}

	private void setCurrentWorkspaceTitle() {
		Tab currentTab = mainView.getSelectionModel().getSelectedItem();
		title = currentTab.getText();
		//return Integer.parseInt(currentTab.getText());
	}

	private void initScene() {
		myScene = new Scene(mainView, SCENE_WIDTH, SCENE_HEIGHT, Color.WHITE);
	}

	public void createNewWorkSpace() {
		numWorkspaces++;
		Tab tab = new Tab();
		if (stringExists(title)) {
			tab.setText(title);
		} else {
			tab.setText(/* "Workspace #"+ */Integer.toString(numWorkspaces));
		}
		tab.setContent(initWorkspace().getMyRoot());
		// add tab to tabpane
		mainView.getTabs().add(tab);
	}

	private Workspace initWorkspace() {
		Workspace slogo;
		if (stringExists(backgroundColor)) {
			slogo = new Workspace(numWorkspaces, backgroundColor);
		} else {
			slogo = new Workspace(numWorkspaces);
		}
		if (stringExists(language)) {
			System.out.println("Language: " + language);
			slogo.setResources(ResourceBundle.getBundle(LANGUAGEPATH + language));
		}
		workspaces.add(slogo);
		slogo.init(this);
		// slogo.setWorkspaceID(numWorkspaces);
		return slogo;
	}

	public Map<String, String> parseWorkspaceData() {
		System.out.println("There is a title!2: " + this.title);
		setCurrentWorkspaceTitle();
		Map<String, String> data = new HashMap<String, String>();
		data.put("title", title);
		data.put("background_color", backgroundColor);
		data.put("language", "current language here"); // TODO: add the correct
														// values
		data.put("numTurtles", "some number");
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
