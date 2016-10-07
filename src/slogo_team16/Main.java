package slogo_team16;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Main class
 */
/**
 * @author Lucy Zhang
 *
 */
public class Main extends Application {

	public static final double WIDTH = SLogoInterface.WIDTH * 1.7;
	public static final double HEIGHT = SLogoInterface.HEIGHT * 1.4;
	public static final String title = "Slogo";
	private SLogoInterface slogo;

	@Override
	public void start(Stage s){
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		slogo = new SLogoInterface();
		s.setTitle(title);

		// attach game to the stage and display it
		s.setX(primaryScreenBounds.getMinX());
        s.setY(primaryScreenBounds.getMinY());
        s.setWidth(primaryScreenBounds.getWidth());
        s.setHeight(primaryScreenBounds.getHeight());

		Scene scene = slogo.init();
		s.setScene(scene);
		s.show();

	}

	/**
	 * Start the program.
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
