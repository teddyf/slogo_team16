package slogo_team16;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class SLogoInterface {
	private Scene myScene;
	private Graphics graphic;
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
		double cellWidth = Dimension.SCENE_WIDTH.getValue() / cols;
		double cellHeight = Dimension.SCENE_HEIGHT.getValue() / rows;
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
		return (x == TurtleEnumChangeThisName.TURTLE_X.getValue() && y == TurtleEnumChangeThisName.TURTLE_Y.getValue());
	}

	private void populateMainPane(Group root) {
		Pane pane = new Pane();
		pane.getChildren().addAll(shapesOnGrid);
		mainPane = graphic.createBorderPane(root, Dimension.SCENE_WIDTH.getValue(), Dimension.SCENE_HEIGHT.getValue());
		BorderPane.setAlignment(root, Pos.CENTER);
		mainPane.setLeft(pane);
		mainPane.getLeft().setId("grid");
	}

}
