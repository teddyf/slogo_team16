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
	private SlogoView slogoView;

//	public SlogoView getSlogoView(){
//		return slogoView;
//	}

	@Override
	public void start(Stage s){
		HomeSelection home = new HomeSelection(s);
		home.initHomeScreen();
		/*
		slogoView = new SlogoView();
		Scene scene = slogoView.init();
		scene.getStylesheets().add(this.getClass().getResource("SLogoStyle.css").toExternalForm());
		
		
		s.setTitle(title);
		s.setScene(scene);
		s.show();
		*/
	}

	public static void main(String[] args) {
		launch(args);
	}

}
