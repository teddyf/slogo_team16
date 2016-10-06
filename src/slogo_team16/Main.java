package slogo_team16;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static final double WIDTH = SLogoInterface.WIDTH * 1.5;
	public static final double HEIGHT = SLogoInterface.HEIGHT * 1.4;
	public static final String title = "Slogo";
	private SLogoInterface slogo;

	@Override
	public void start(Stage s){

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
