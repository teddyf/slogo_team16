package slogo_team16;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SLogoInterface {
	private Scene myScene;
	private Graphics graphic;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 400;
	private BorderPane borderPane; 
	
	public SLogoInterface(){
		graphic = new Graphics();
	}
	
	public Scene init(int width, int height){
		Group root = new Group();
		myScene = new Scene(root, width, height, Color.WHITE);
	
		return myScene;
	}
	
	private void createTurtleGrid(Group root){
		Image turtle = graphic.createImage("turtleLogo.png");
		BorderPane mainPane = graphic.createBorderPane(root, WIDTH,HEIGHT);
		root.getChildren().add(mainPane);
		
	}
	
	private void populateMainPane(Group root) {
		Pane pane = new Pane();
		pane.getChildren().addAll(shapesOnGrid);
		BorderPane mainPane = graphic.createBorderPane(root, WIDTH,HEIGHT);
		BorderPane.setAlignment(root, Pos.CENTER);
		mainPane.setMinHeight(height);
		mainPane.setLeft(pane);
		mainPane.getLeft().setId("grid");
	}
	
	private BorderPane createGridPane(Pos position, int hGap, int vGap){
		BorderPane grid = new BorderPane();

        return grid;
	}

}
