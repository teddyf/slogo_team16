package main;

import View.HomeSelection;
import View.SlogoView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @author Lucy Zhang, Jordan Frazier, Teddy Franceschi, Aninda Manocha
 */
public class Main extends Application {

	public static final String TITLE = "Slogo";
	private Stage stage;

	
	public Stage getStage(){
		return stage;
	}

	@Override
	public void start(Stage s){
		this.stage = s;
		HomeSelection home = new HomeSelection(s);
		home.initHomeScreen();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
