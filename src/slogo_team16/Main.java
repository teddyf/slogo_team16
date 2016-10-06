package slogo_team16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static final int WIDTH = 700;
	public static final int HEIGHT = 500;
	public static final String title = "Slogo";
	private SLogoInterface slogo;

	/**
	 * Set things up at the beginning.
	 */
	@Override
	public void start(Stage s) {

		slogo = new SLogoInterface();
		s.setTitle(title);

		// attach game to the stage and display it
		Scene scene = slogo.init(WIDTH, HEIGHT);
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
