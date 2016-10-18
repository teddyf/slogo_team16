package View.helper;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;


/**
 * 
 *
 */
public class SceneManager {
	private Scene myScene;
	private Stage mainStage;

	public SceneManager() {
		mainStage = new Stage();
	}

	/**
	 * Creates a new scene
	 * 
	 * @param stage
	 *            The current stage
	 * @param title
	 *            The title of the new scene
	 * @param width
	 * @param height
	 * @return the Group object
	 */
	public Group setupNewScene(String title, double width, double height) {
		mainStage.setTitle(title);
		Group root = new Group();
		myScene = new Scene(root, width, height, Color.WHITE);
		mainStage.setScene(myScene);
		mainStage.show();
		return root;
	}

	
}
