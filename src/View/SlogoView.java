package View;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SlogoView {
	private TabPane mainView = new TabPane();
	private VBox myRoot;
	private Scene myScene;
	public static final int SCENE_WIDTH = 1200;
	public static final int SCENE_HEIGHT = 700;
	private int numWorkspaces;

	public SlogoView() {

	}

	public void setUpSlogo() {
		numWorkspaces = 0;
		myRoot = new VBox();
		mainView = new TabPane();
		myRoot.getChildren().add(mainView);
		makeWorkSpace();
		initScene();

	}

	private void initScene() {
		myScene = new Scene(myRoot, SCENE_WIDTH, SCENE_HEIGHT, Color.WHITE);
		myScene.getStylesheets().add(this.getClass().getResource("SLogoStyle.css").toExternalForm());
	}

	public Scene getScene() {
		return myScene;
	}

	public TabPane getMainView() {
		return mainView;
	}

	public void makeWorkSpace() {
		numWorkspaces++;
		Tab tab = new Tab();
		// add borderpane to the tab
		tab.setContent(initWorkspaceScene().getMyRoot());
		// add tab to tabpane
		mainView.getTabs().add(tab);
	}

	private Workspace initWorkspaceScene() {
		Workspace slogo = new Workspace();
		slogo.init(this);
		slogo.setWorkspaceID(numWorkspaces);
		return slogo;
	}

}
