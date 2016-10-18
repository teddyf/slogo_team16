package View;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;

public class SlogoView {

	public static final int SCENE_WIDTH = 1200;
	public static final int SCENE_HEIGHT = 700;
	
	private TabPane mainView = new TabPane();
	private Scene myScene;
	private int numWorkspaces;

	public SlogoView() {
		numWorkspaces = 0;
		mainView = new TabPane();
	}

	public Scene init() {
		initScene();
		createNewWorkSpace();
		return myScene;
	}

	private void initScene() {
		myScene = new Scene(mainView, SCENE_WIDTH, SCENE_HEIGHT, Color.WHITE);
	}

	public void createNewWorkSpace() {
		numWorkspaces++;
		Tab tab = new Tab();
		tab.setText("Workspace #"+numWorkspaces);
		tab.setContent(initWorkspace().getMyRoot());
		// add tab to tabpane
		mainView.getTabs().add(tab);
	}

	private Workspace initWorkspace() {
		Workspace slogo = new Workspace(numWorkspaces);
		slogo.init(this);
//		slogo.setWorkspaceID(numWorkspaces);
		return slogo;
	}
	
	public Scene getScene() {
		return myScene;
	}

	public TabPane getMainView() {
		return mainView;
	}

}
