package slogo_team16;

import java.util.ArrayList;
import java.util.List;

import Animals.Animal;
import Animals.Turtle;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Main SLogo interface
 */
/**
 * @author Lucy Zhang
 * @author Jordan Frazier
 *
 */
public class SLogoInterface {
	private Scene myScene;
	private Graphics graphic;
	public static final int SCENE_WIDTH = 1200;
	public static final int SCENE_HEIGHT = 700;
	private static final int LEFT_PANE_WIDTH = SCENE_WIDTH - SCENE_WIDTH / 3;
	private static final int RIGHT_PANE_WIDTH = SCENE_WIDTH / 3 - 30;

	private BorderPane myRoot;
	private Pane myAnimalPane;
	private List<Animal> myAnimalList;
	private Buttons buttons;
	private Console console;
	private Animate animation;
	private final ListView<String> historyScroller = new ListView<>();

	public SLogoInterface() {
		graphic = new Graphics();
		buttons = new Buttons();
		animation = new Animate();
		myAnimalList = new ArrayList<>();
	}

	public Scene init() {
		myRoot = new BorderPane();
		myScene = new Scene(myRoot, SCENE_WIDTH, SCENE_HEIGHT, Color.WHITE);
		populateLeftPane();
		populateRightPane();
		populateGridWithAnimals(1);
		return myScene;
	}

	private void populateLeftPane() {
		// Better to return object, or to pass in the leftpane and add inside
		// method?
		VBox leftPane = createVBoxPane(LEFT_PANE_WIDTH);
		Text title = createTitle();
		HBox container = createConsole();
		createAnimalPane();
		leftPane.getChildren().addAll(title, myAnimalPane, container);
		myRoot.setLeft(leftPane);
	}

	private void populateRightPane() {
		VBox rightPane = createVBoxPane(RIGHT_PANE_WIDTH);
		Text history = createHistoryTitle();
		createHistoryPane();
		rightPane.getChildren().addAll(history, historyScroller);
		myRoot.setRight(rightPane);
	}

	private Text createHistoryTitle() {
		Text history = new Text("History");
		return history;
	}

	private VBox createVBoxPane(int width) {
		VBox vbox = new VBox(10);
		vbox.setMaxWidth(width);
		vbox.setMinWidth(width);
		vbox.setMinHeight(SCENE_HEIGHT - 30);
		vbox.setPadding(new Insets(15));
		return vbox;
	}

	private void createHistoryPane() {
//		historyScroller.getItems().add(new TextArea("First history command"));
		historyScroller.getItems().add("First history\nCommand\nyeah");
		historyScroller.setStyle("-fx-background: white");
	}

	public Text createTitle() {
		Text title = new Text("Slogo");
		return title;
	}

	private void createAnimalPane() {
		myAnimalPane = new Pane();
		myAnimalPane.setPrefWidth(LEFT_PANE_WIDTH);
		myAnimalPane.setPrefHeight(SCENE_HEIGHT - SCENE_HEIGHT / 6);
		myAnimalPane.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null)));
		myAnimalPane.setStyle("-fx-background-color: white");
	}

	private HBox createConsole() {
		TextArea consoleArea = createConsoleArea();
		VBox buttons = createButtons();
		HBox consoleContainer = new HBox(5);
		consoleContainer.getChildren().addAll(consoleArea, buttons);
		return consoleContainer;
	}

	private TextArea createConsoleArea() {
		// TODO: Jordan - input correct width / height (doesn't matter)
		TextArea consoleArea = graphic.createConsoleTextArea(LEFT_PANE_WIDTH - 100, SCENE_HEIGHT / 6);
		console = new Console(consoleArea);
		console.initConsole();
		return consoleArea;
	}

	private VBox createButtons() {
		// TODO: Jordan - Is it better to pass in container, or to return a
		// container created inside the other class?
		VBox container = new VBox(5);
		buttons.createConsoleInputButtons(container, console, historyScroller);
		return container;
	}

	// Maybe specific animal buttons that call this, which adds to animallist,
	// then the list is completely rendered by calling populateGridWithAnimals()
	private void addAnimal(Animal animal) {
		myAnimalList.add(animal);
		fillAnimalGrid();
	}

	// This method needs to change, discuss if/how we would let a user define
	// what animals
	// they want, or how many they want
	private void fillAnimalList(int numAnimals) {
		for (int i = 0; i < numAnimals; i++) {
			Turtle turtle = new Turtle(15, 15, (LEFT_PANE_WIDTH) / 2, myAnimalPane.getPrefHeight() / 2);
			myAnimalList.add(turtle);
		}
	}

	private void populateGridWithAnimals(int numAnimals) {
		fillAnimalList(numAnimals);
		fillAnimalGrid();
	}

	private void fillAnimalGrid() {
		for (Animal animal : myAnimalList) {
			renderAnimal(animal);
		}
	}

	private void renderAnimal(Animal animal) {
		if (isValidLocation(animal.getX(), animal.getY())) {
			addAnimalToGrid(animal);
		} else {
			// not valid location. error dialog. or maybe not
		}
	}

	private void addAnimalToGrid(Animal animal) {
		Rectangle s = graphic.createRectCell(animal.getX(), animal.getY(), animal.getWidth(), animal.getHeight(),
				Color.WHITE, Color.WHITE);
		Image turtle = graphic.createImage("turtleLogo.png");
		ImagePattern turtlePattern = new ImagePattern(turtle);
		s.setFill(turtlePattern);
		myAnimalPane.getChildren().add(s);
	}

	// are we going to let turtle go off of the screen?
	private boolean isValidLocation(double x, double y) {
		return (x > myScene.getX()) && (y > myScene.getY()) && (x < myScene.getWidth()) && (y < myScene.getHeight());
	}

}
