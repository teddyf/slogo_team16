package slogo_team16;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
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
	public static final int WIDTH = 700;
	public static final int HEIGHT = 600;
	public static final int TURTLE_X = 5;
	public static final int TURTLE_Y = 5;
	private BorderPane mainPane;
	private ArrayList<Rectangle> shapesOnGrid;

	public SLogoInterface() {
		graphic = new Graphics();
		shapesOnGrid = new ArrayList<Rectangle>();
	}

	public Scene init(int width, int height) {
		Group root = new Group();
		myScene = new Scene(root, width, height, Color.WHITE);
		populateGrid(root, 20, 20);
		return myScene;
	}

	private void populateGrid(Group root, int rows, int cols) {
		double cellWidth = WIDTH / cols;
		double cellHeight = HEIGHT / rows;
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				Rectangle s = graphic.createRectCell(i, j, cellWidth, cellHeight, Color.BLACK, Color.WHITE);
				if (okToPlaceTurtle(i, j)) {
					System.out.println("Turtle: ");
					Image turtle = graphic.createImage("turtleLogo.png");
					System.out.println(turtle);
					ImagePattern turtlePattern = new ImagePattern(turtle);
					s.setFill(turtlePattern);
				}
				shapesOnGrid.add(s);

			}
		}
		populateMainPane(root);
	}

	private boolean okToPlaceTurtle(int x, int y) {
		return (x == TURTLE_X && y == TURTLE_Y);
	}

	private void populateMainPane(Group root) {
		Pane pane = new Pane();
		pane.getChildren().addAll(shapesOnGrid);
		mainPane = graphic.createBorderPane(root, WIDTH, HEIGHT);
		BorderPane.setAlignment(root, Pos.CENTER);
		mainPane.setLeft(pane);
		mainPane.getLeft().setId("grid");
	}

}
