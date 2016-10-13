package View;

import java.util.ArrayList;
import java.util.List;

import Animals.Animal;
import Animals.Turtle;
import View.tab_panes.CommandHistoryPane;
import View.tab_panes.ExampleCommandsPane;
import View.tab_panes.GenericPane;
import View.tab_panes.OptionsPane;
import View.tab_panes.VariablesPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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
public class SLogoView {
	private Scene myScene;
	private Graphics graphics;
	public static final int SCENE_WIDTH = 1200;
	public static final int SCENE_HEIGHT = 700;
	private static final int LEFT_PANE_WIDTH = SCENE_WIDTH - SCENE_WIDTH / 3;
	private static final int RIGHT_PANE_WIDTH = SCENE_WIDTH / 3 - 30;
	private static final int TURTLE_HEIGHT = 15;
	private static final int TURTLE_WIDTH = 15;
	
	private BorderPane myRoot;
	private Pane myAnimalPane;
	private List<Animal> myAnimalList;
	private Buttons buttons;
	private Console console;
	private Animate animation;
	private final GenericPane historyPane = new CommandHistoryPane();
	
	public SLogoView() {
		graphics = new Graphics();
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
		VBox leftPane = graphics.createVBoxPane(LEFT_PANE_WIDTH, SCENE_HEIGHT);	
		HBox upperPanel = createUpperPanel();
		HBox container = createConsole();
		createAnimalPane();
		
		leftPane.getChildren().addAll(upperPanel, myAnimalPane, container);
		myRoot.setLeft(leftPane);
	}

	private void populateRightPane() {
		// TODO: Jordan - something about insets? 
		VBox rightPane = graphics.createVBoxPane(RIGHT_PANE_WIDTH, SCENE_HEIGHT, new Insets(51, 45, 15, 0));
		TabPane informationTabPane = createTabInfoPane();
		
		rightPane.getChildren().addAll(informationTabPane);
		myRoot.setRight(rightPane);
	}
	
	private TabPane createTabInfoPane() {
		TabPane tabPane = new TabPane();
		Tab examples = createExampleCommandsTab();
		Tab variables = createVariablesTab();
		Tab history = createHistoryTab();
		Tab options = createOptionsTab();
		tabPane.getTabs().addAll(history, examples, variables, options);
		return tabPane;
	}
	
	private Tab createTab(GenericPane pane) {
		Tab tab = new Tab();
		tab.setContent((Node) pane);
		tab.setText(pane.getTabName());
		tab.setClosable(false);
		return tab;
	}
	
	private Tab createExampleCommandsTab() {
		GenericPane pane = new ExampleCommandsPane();
		Tab tab = createTab(pane);
		return tab;
	}
	
	private Tab createVariablesTab() {
		GenericPane pane = new VariablesPane();
		Tab tab = createTab(pane);
		return tab;
	}
	
	private Tab createHistoryTab() {
		Tab tab = createTab(historyPane);
		return tab;
	}
	
	private Tab createOptionsTab() {
		GenericPane pane = new OptionsPane();
		Tab tab = createTab(pane);
		return tab;
	}
	
	private HBox createUpperPanel() {
		HBox container = new HBox(20);
		Text title = new Text("Slogo");
		ComboBox<String> languageComboBox = createLanguageChooser();
		container.getChildren().addAll(title, languageComboBox);
		return container;
	}

	private void createAnimalPane() {
		myAnimalPane = new Pane();
		myAnimalPane.setPrefWidth(LEFT_PANE_WIDTH);
		myAnimalPane.setPrefHeight(SCENE_HEIGHT - SCENE_HEIGHT / 4);
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
		TextArea consoleArea = graphics.createConsoleTextArea(LEFT_PANE_WIDTH - 100, SCENE_HEIGHT / 6);
		console = new Console(consoleArea);
		console.initConsole();
		return consoleArea;
	}

	private VBox createButtons() {
		VBox container = buttons.createConsoleInputButtons(console, historyPane);
		return container;
	}

	// Maybe specific animal buttons that call this, which adds to animallist,
	// then the list is completely rendered by calling populateGridWithAnimals()
	private void addAnimal(Animal animal) {
		myAnimalList.add(animal);
		fillAnimalGrid();
	}

	// This method needs to change, discuss if/how we would let a user define
	// what animals they want, or how many they want
	private void fillAnimalList(int numAnimals) {
		for (int i = 0; i < numAnimals; i++) {
			Animal turtle = new Turtle(TURTLE_WIDTH, TURTLE_HEIGHT, (myAnimalPane.getPrefWidth() - myAnimalPane.getLayoutX()) / 2,
					(myAnimalPane.getPrefHeight() - myAnimalPane.getLayoutY()) / 2);
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
		Rectangle s = graphics.createRectCell(animal.getX(), animal.getY(), animal.getWidth(), animal.getHeight(),
				Color.WHITE, Color.WHITE);
		Image turtle = graphics.createImage("turtleLogo.png");
		ImagePattern turtlePattern = new ImagePattern(turtle);
		s.setFill(turtlePattern);
		myAnimalPane.getChildren().add(s);
	}

	// are we going to let turtle go off of the screen?
	private boolean isValidLocation(double x, double y) {
		return (x > myScene.getX()) && (y > myScene.getY()) && (x < myScene.getWidth()) && (y < myScene.getHeight());
	}

	private ComboBox<String> createLanguageChooser() {
		String[] languages = { "English", "Chinese", "French", "German", "Italian", "Portuguese", "Russian",
				"Spanish" };
		ComboBox<String> languageSelector = graphics.createComboBox(languages);
		languageSelector.setValue(languages[0]);
		languageSelector.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("combbox value is: " + newValue);
				//TODO: change the language
			}
		});
		return languageSelector;
	}

}
