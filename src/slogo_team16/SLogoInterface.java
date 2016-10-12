package slogo_team16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Animals.Animal;
import Animals.Turtle;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
 *
 */
public class SLogoInterface {
	private Scene myScene;
	private Graphics graphic;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 400;

	private BorderPane myRoot;
	private Pane myAnimalPane;
	private List<Animal> myAnimalList; // for later on, in case more animals show
	private Buttons buttons;
	private Console console;
	private Animate animation;

	public SLogoInterface() {
		graphic = new Graphics();
		buttons = new Buttons();
		animation = new Animate();
		myAnimalList = new ArrayList<>();
	}

	public Scene init() {
		myRoot = new BorderPane();
		myScene = new Scene(myRoot, WIDTH, HEIGHT, Color.WHITE);
		populateLeftPane();
		populateGridWithAnimals(1);
		return myScene;
	}

	private void populateLeftPane() {
		// Better to return object, or to pass in the leftpane and add inside
		// method?
		VBox leftPane = createLeftPane();
		Text title = createTitle();
		Pane grid = createMainGrid();
		HBox container = createConsole();
		leftPane.getChildren().addAll(title, grid, container);
		myRoot.setLeft(leftPane);
		createLanguageChooser();
	}

	private VBox createLeftPane() {
		VBox leftPane = new VBox(10);
		leftPane.setPadding(new Insets(20, 20, 20, 50));
		return leftPane;
	}

	public Text createTitle() {
		Text title = new Text("Slogo");
		return title;
	}

	private Pane createMainGrid() {
		myAnimalPane = new Pane();
		myAnimalPane.setPrefWidth(WIDTH);
		myAnimalPane.setPrefHeight(HEIGHT);
		myAnimalPane.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null)));
		myAnimalPane.setStyle("-fx-background-color: white");
		return myAnimalPane;
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
		TextArea consoleArea = graphic.createConsoleTextArea(WIDTH, HEIGHT);
		console = new Console(consoleArea);
		console.initConsole();
		return consoleArea;
	}

	private VBox createButtons() {
		// TODO: Jordan - Is it better to pass in container, or to return a
		// container created inside the other class?
		VBox container = new VBox(5);
		buttons.createConsoleInputButtons(container, console);
		return container;
	}
	
	// Maybe specific animal buttons that call this, which adds to animallist, then the list
	// is completely rendered by calling populateGridWithAnimals()
	private void addAnimal(Animal animal) {
		myAnimalList.add(animal);
	}

	// This method needs to change, discuss if/how we would let a user define what animals
	// they want, or how many they want
	private void fillAnimalList(int numAnimals) {
		for (int i = 0; i < numAnimals; i++) {
			Turtle turtle = new Turtle((myAnimalPane.getPrefWidth() - myAnimalPane.getLayoutX()) / 2, (myAnimalPane.getPrefHeight() - myAnimalPane.getLayoutY()) / 2, 15, 15);
			myAnimalList.add(turtle);
		}
	}

	private void populateGridWithAnimals(int numAnimals) {
		fillAnimalList(numAnimals);
		for (Animal animal : myAnimalList) {
			// they're all turtles now so 
			renderAnimal(animal);
		}
	}

	private void renderAnimal(Animal animal) {
		if (isValidLocation(animal.getX(), animal.getY())) {
			Rectangle s = graphic.createRectCell(animal.getWidth(), animal.getHeight(), animal.getX(), animal.getY(),
					Color.WHITE, Color.WHITE);
			Image turtle = graphic.createImage("turtleLogo.png");
			ImagePattern turtlePattern = new ImagePattern(turtle);
			s.setFill(turtlePattern);
			myAnimalPane.getChildren().add(s);
		} else {
			// not valid location. error dialog
		}
	}

	private boolean isValidLocation(double x, double y) {
		return (x > myScene.getX()) && (y > myScene.getY()) && (x < myScene.getWidth()) && (y < myScene.getHeight());
	}
	
	private void createLanguageChooser(){
		String[] languages = {"English", "Chinese","French","German","Italian","Portuguese","Russian","Spanish"};
		ComboBox language = graphic.createComboBox(languages);
		myRoot.setBottom(language);
	}

}
