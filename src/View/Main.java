package View;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;


/**
 * @author Lucy Zhang, Jordan Frazier, Teddy Franceschi, Aninda Manocha
 */
public class Main extends Application {

	public static final String title = "Slogo";
	private SLogoView slogo;

	@Override
	public void start(Stage s){
		slogo = new SLogoView();
		Scene scene = slogo.init();
		s.setTitle(title);
		s.setScene(scene);
		s.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
