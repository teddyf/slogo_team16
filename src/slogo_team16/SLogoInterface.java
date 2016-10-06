package slogo_team16;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SLogoInterface {
	private Scene myScene;
	private Graphics graphic;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 400;
	public static final int TURTLE_X = 5;
	public static final int TURTLE_Y = 5;
	public static final int COLUMNS =  10;
	public static final int ROWS = 10;
	
	private BorderPane mainPane;
	private ArrayList<Rectangle> shapesOnGrid;
	private Turtle turtle;


	public SLogoInterface() {
		graphic = new Graphics();
		shapesOnGrid = new ArrayList<Rectangle>();
	}

	public Scene init(double width, double height) {
		Group root = new Group();
		myScene = new Scene(root, width, height, Color.WHITE);
		turtle = new Turtle(TURTLE_X, TURTLE_Y);
		populateGrid(root, COLUMNS, ROWS);
		createConsole();
		return myScene;
	}

	private void populateGrid(Group root, int rows, int cols) {
		double cellWidth = WIDTH / cols;
		double cellHeight = HEIGHT / rows;
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				Rectangle s = graphic.createRectCell(i, j, cellWidth, cellHeight, Color.BLACK, Color.WHITE);
				if (okToPlaceTurtle(i, j)) {
					Image turtle = graphic.createImage("turtleLogo.png");
					ImagePattern turtlePattern = new ImagePattern(turtle);
					s.setFill(turtlePattern);
				}
				shapesOnGrid.add(s);

			}
		}
		populateMainPane(root);
	}

	private boolean okToPlaceTurtle(int x, int y) {
		return (x == turtle.getX() && y == turtle.getY());
	}

	private void populateMainPane(Group root) {
		Pane pane = new Pane();
		pane.getChildren().addAll(shapesOnGrid);
		mainPane = graphic.createBorderPane(root, WIDTH, HEIGHT);
		BorderPane.setAlignment(root, Pos.CENTER);
		mainPane.setLeft(pane);
		mainPane.getLeft().setId("grid");
	}
	
	private void createConsole(){
		TextArea consoleArea = new TextArea();
		consoleArea.setMaxHeight(HEIGHT/3);
		consoleArea.setTranslateY(HEIGHT/2.5);
		mainPane.setBottom(consoleArea);
		//mainPane.getBottom().setTranslateY(HEIGHT/2.5);
		Console console = new Console(consoleArea);
		console.writeToConsole("Hihihihi");
		
	}

}
