package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @author Lucy Zhang, Jordan Frazier, Teddy Franceschi, Aninda Manocha
 */
public class Main extends Application {

	public static final String title = "Slogo";
	private Workspace slogo;
	private SlogoView slogoView;

	private Stage primaryStage;
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public SlogoView getSlogoView(){
		return slogoView;
	}
	
	@Override
	public void start(Stage s){
		primaryStage = s;
		/*
		slogo = new Workspace();
		Scene scene = slogo.init();
		scene.getStylesheets().add(this.getClass().getResource("SLogoStyle.css").toExternalForm());
		*/
		slogoView = new SlogoView();
		slogoView.setUpSlogo();
		System.out.println("Made slogoView");
		Scene scene = slogoView.getScene();
		System.out.println("MAde scene: "+scene);
		s.setTitle(title);
		s.setScene(scene);
		s.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
