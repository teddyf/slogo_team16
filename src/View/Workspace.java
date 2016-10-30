package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import Controller.AnimalController;
import Controller.Controller;
import View.helper.Animate;
import View.helper.Buttons;
import View.helper.Colors;
import View.helper.Console;
import View.helper.Graphics;
import View.tabs.CommandHistoryPane;
import View.tabs.ExampleCommandsPane;
import View.tabs.GenericPane;
//import View.tabs.ListeningPane;
import View.tabs.OptionsPane;
import View.tabs.VariablesPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.AnimalPane;
import model.animal.Animal;
import model.animal.Turtle;

/**
 * Main SLogo interface
 *
 * @author Lucy Zhang
 * @author Jordan Frazier
 *
 */
public class Workspace implements Observer {
	private Scene myScene;
	private Graphics graphics;
	public static final int SCENE_WIDTH = 1200;
	public static final int SCENE_HEIGHT = 670;
	public static final int LEFT_PANE_WIDTH = SCENE_WIDTH - SCENE_WIDTH / 3;
	public static final int LEFT_PANE_HEIGHT = Workspace.SCENE_HEIGHT - Workspace.SCENE_HEIGHT / 4;
	public static final int RIGHT_PANE_WIDTH = SCENE_WIDTH / 3 - 30;
	public static final int TURTLE_HEIGHT = 15;
	public static final int TURTLE_WIDTH = 15;
	public static final int BUTTON_WIDTH = 140;

	private String defaultBackgroundColor;
	private final String EN_RESRC_PATH = "resources/languages/English";
	private final String[] languages = { "English", "Chinese", "French", "German", "Italian", "Portuguese", "Russian",
			"Spanish" };

	private BorderPane myRoot;
	// private AnimalPane myAnimalPane;
	private List<AnimalPaneGUI> myAnimalGUIList;
	private Buttons buttons;
	private Console console;
	private Animate animation;
	private ResourceBundle myResources;
	private Controller myController;
	private GenericPane<String> historyPane;
	private int workSpaceID;
	private SlogoView mainView;

	// support for multiple turtles
	private int numTurtles;
	private ArrayList<String> turtleIDs = new ArrayList<String>();
	private AnimalClick animalClick;

	// There is only one instance of an AnimalPaneGUI per workspace
	private AnimalPaneGUI myAnimalPaneGUI;

	public Workspace(int workspaceID) {
		graphics = new Graphics();
		myController = new AnimalController();
		buttons = new Buttons(myController);
		animation = new Animate();
		myAnimalGUIList = new ArrayList<>();
		myResources = ResourceBundle.getBundle(EN_RESRC_PATH);
		console = new Console();
		this.workSpaceID = workspaceID;
		numTurtles = 0;
		animalClick = new AnimalClick();
		createAnimalPaneGUI();
		// animalClick= new AnimalClick(myAnimalPaneGUI);
	}

	public Workspace(int workspaceID, String color) {
		graphics = new Graphics();
		myController = new AnimalController();
		buttons = new Buttons(myController);
		animation = new Animate();
		myAnimalGUIList = new ArrayList<>();
		myResources = ResourceBundle.getBundle(EN_RESRC_PATH);
		console = new Console();
		this.workSpaceID = workspaceID;
		this.defaultBackgroundColor = color;
		numTurtles = 0;
		animalClick = new AnimalClick();
		createAnimalPaneGUI();
		// animalClick= new AnimalClick(myAnimalPaneGUI);

	}

	public int getNumTurtles() {
		return numTurtles;
	}

	public Console getConsole() {
		return this.console;
	}

	public void setNumTurtles(int numTurtles) {
		this.numTurtles = numTurtles;
	}

	@Deprecated
	public void incrementNumTurtles() {
		// numTurtles++;
		// Animal newAnimal = new Turtle(50,50,30,20);//TODO: change the dummy
		// numbers
		// myAnimalPaneGUI.addAnimal(newAnimal);
		// addAnimalToGrid(newAnimal);
		createAnimal();
		System.out.println("Incremented turtles: " + myAnimalPaneGUI.getAnimalPane().getMyAnimalList());
	}

	public void decrementNumTurtles() {
		if (numTurtles > 1) {
			numTurtles--;
		}
	}

	public List<String> getTurtleIDs() {
		return turtleIDs;
	}

	public void init(SlogoView view) {
		mainView = view;
		myRoot = new BorderPane();
		// createAnimalPaneGUI();
		populateTopPane();
		populateLeftPane();
		populateRightPane();
		mainView.setBackgroundColor(defaultBackgroundColor);
	}

	public void createAnimalPaneGUI() {
		myAnimalPaneGUI = new AnimalPaneGUI();
		myAnimalGUIList.add(myAnimalPaneGUI);
		myAnimalPaneGUI.getAnimalPane().addObserver(this);
		createAnimal();
		myController.setActiveAnimalPaneGUI(myAnimalPaneGUI);
	}

	public AnimalPane createAnimalPane() {
		AnimalPane animalPane = new AnimalPane();
		// myController.setActiveAnimalPane(animalPane);
		animalPane.addObserver(this);
		return animalPane;
	}

	private void populateTopPane() {
		HBox container = new HBox(20);
		container.getStyleClass().add("top-pane");

		Text title = new Text(myResources.getString("SLogo"));
		title.getStyleClass().add("slogo-title");

		ComboBox<String> languageComboBox = createLanguageChooser();
		languageComboBox.getStyleClass().add("language-button");

		// Button tb = CREATETESTBUTTON();

		// container.getChildren().addAll(title, languageComboBox, tb);
		container.getChildren().addAll(title, languageComboBox);

		myRoot.setTop(container);
	}

	private void populateLeftPane() {
		VBox leftPane = graphics.createVBoxPane(LEFT_PANE_WIDTH, SCENE_HEIGHT);
		leftPane.getStyleClass().add("left-pane");

		ScrollPane container = createConsole();
//		populateGridWithAnimals();

		leftPane.getChildren().addAll(myAnimalPaneGUI.getScrollPane(), container);
		myRoot.setLeft(leftPane);
	}

	public void resetLeftPane() {
		// myRoot.setLeft(null);
		ScrollPane newPane = new ScrollPane();
		Pane myContainer = new Pane();
		myAnimalPaneGUI.setScrollPane(newPane);
		myAnimalPaneGUI.styleScrollPane();
		myAnimalPaneGUI.setMyContainer(myContainer);
		myAnimalPaneGUI.styleMyContainer();
		populateLeftPane();
	}

	private void populateRightPane() {
		VBox rightPane = graphics.createVBoxPane(RIGHT_PANE_WIDTH, SCENE_HEIGHT);
		rightPane.getStyleClass().add("right-pane");

		TabPane informationTabPane = createTabInfoPane();
		informationTabPane.getStyleClass().add("tab-pane");

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

	private <T> Tab createTab(GenericPane<T> pane) {
		Tab tab = new Tab();
		tab.setContent(pane.getTabContent());
		tab.setText(pane.getTabName());
		tab.setClosable(false);
		return tab;
	}

	private Tab createExampleCommandsTab() {
		GenericPane<String> pane = new ExampleCommandsPane();
		Tab tab = createTab(pane);
		return tab;
	}

	private Tab createVariablesTab() {
		GenericPane<String> pane = new VariablesPane();
		Tab tab = createTab(pane);
		return tab;
	}

	private Tab createHistoryTab() {
		historyPane = new CommandHistoryPane(console);
		buttons.addObserver(historyPane);
		Tab tab = createTab(historyPane);
		return tab;
	}

	private Tab createOptionsTab() {
		GenericPane<HBox> pane = new OptionsPane(myAnimalPaneGUI, this, mainView);
		// if (defaultBackgroundColor != null &&
		// !defaultBackgroundColor.isEmpty()){
		// System.out.println("default background color:
		// "+defaultBackgroundColor);
		// ((OptionsPane) pane).changeBackgroundColor(defaultBackgroundColor);
		// }
		// to make custom ID buttons
		Tab tab = createTab(pane);
		return tab;
	}

	public ScrollPane createConsole() {
		ScrollPane consolePane = new ScrollPane();
		// TextArea consoleArea = createConsoleArea();
		VBox buttons = createButtons();
		HBox consoleContainer = new HBox(5);
		consoleContainer.getChildren().addAll(console.getConsoleArea(), buttons);
		consolePane.setContent(consoleContainer);
		return consolePane;
		// return consoleContainer;
	}

	@Deprecated
	public TextArea createConsoleArea() {
		TextArea consoleArea = graphics.createConsoleTextArea(LEFT_PANE_WIDTH - BUTTON_WIDTH, SCENE_HEIGHT / 6);
		console = new Console(consoleArea);
		console.initConsole();
		return consoleArea;
	}

	private VBox createButtons() {
		VBox container = buttons.createConsoleInputButtons(console, historyPane, mainView);
		return container;
	}

	// Maybe specific animal buttons that call this, which adds to animallist,
	// then the list is completely rendered by calling populateGridWithAnimals()
	// private void addAnimal(Animal animal) {
	// getActiveAnimalPane().addAnimal(animal);
	// renderAnimalGrid();
	// }

	// private void fillAnimalList(int numAnimals) {
	// for (int i = 0; i < numAnimals; i++) {
	// Animal turtle = new Turtle(TURTLE_WIDTH, TURTLE_HEIGHT,
	// (myAnimalPaneGUI.getScrollPane().getPrefWidth() -
	// myAnimalPaneGUI.getScrollPane().getLayoutX() - 15) / 2,
	// (myAnimalPaneGUI.getScrollPane().getPrefHeight() -
	// myAnimalPaneGUI.getScrollPane().getLayoutY()) / 2);
	// myAnimalPaneGUI.addAnimal(turtle);
	// }
	// }
	//
	// public void populateGridWithAnimals() {
	// fillAnimalList(NUM_ANIMALS);
	// renderAnimalGrid();
	// }

	public void populateGridWithAnimals() {
		// createAnimal();
		renderAnimalGrid();
	}

	// @Deprecated
	// public void createAnimalOld() {
	// Animal turtle = new Turtle(TURTLE_WIDTH, TURTLE_HEIGHT,
	// (myAnimalPaneGUI.getScrollPane().getPrefWidth() -
	// myAnimalPaneGUI.getScrollPane().getLayoutX() - 15)
	// / 2,
	// (myAnimalPaneGUI.getScrollPane().getPrefHeight() -
	// myAnimalPaneGUI.getScrollPane().getLayoutY()) / 2);
	// myAnimalPaneGUI.addAnimal(turtle);
	// }

	public void createAnimal() {
		numTurtles++;
		Animal animal = myAnimalPaneGUI.addAnimal();
		renderAnimal(animal);
	}

	public void renderAnimalGrid() {
		for (Animal animal : myAnimalPaneGUI.getMyAnimalList()) {
			renderAnimal(animal);
		}
	}

	private void renderAnimal(Animal animal) {
		if (isValidLocation(animal.getX(), animal.getY())) {
			addAnimalToGrid(animal);
		} else {
			// This should never happen since turtle only is added to center of
			// frame, but if this does change
			// we will have a place to handle it here
			System.out.println("NOT INSIDE ANIMAL PANE");
		}
	}

	private void addAnimalToGrid(Animal animal) {
		ImageView animalImage = animal.getImageView();
		animalImage.setFitHeight(TURTLE_HEIGHT);
		animalImage.setFitWidth(TURTLE_WIDTH);
		animalImage.setTranslateX(myAnimalPaneGUI.getScrollPane().getPrefWidth() / 2);
		animalImage.setTranslateY(myAnimalPaneGUI.getScrollPane().getPrefHeight() / 2);

		animalClick.setEventListener(animal);
		if(!myAnimalPaneGUI.getMyContainer().getChildren().contains(animalImage)) {
			myAnimalPaneGUI.getMyContainer().getChildren().add(animalImage);
		}
		myAnimalPaneGUI.getScrollPane().setContent(myAnimalPaneGUI.getMyContainer());
	}

	private boolean isValidLocation(double x, double y) {
		return (x > myAnimalPaneGUI.getScrollPane().getLayoutX()) && (y > myAnimalPaneGUI.getScrollPane().getLayoutY())
				&& (x < myAnimalPaneGUI.getScrollPane().getPrefWidth())
				&& (y < myAnimalPaneGUI.getScrollPane().getPrefHeight());
	}

	public void changeAnimalBackgroundColor(String color) {
		String hexColor = decodeColor(color);
		myAnimalPaneGUI.getMyContainer().setStyle("-fx-background-color: " + hexColor);
		this.getMyRoot().setStyle("-fx-background-color: " + hexColor + ";");
	}

	private String decodeColor(String color) {
		return Colors.BLACK.getColorMap().get(color);
//		for (Colors c : Colors.values()) {
//			if (c.toString().equals(color)) {
//				return c.getHexColor();
//			}
//		}
//		return null;
	}

	public ComboBox<String> createLanguageChooser() {
		ComboBox<String> languageSelector = graphics.createComboBox(languages);
		languageSelector.setValue(languages[0]);
		languageSelector.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				myController.setParsingLanguage(newValue);
			}
		});
		return languageSelector;
	}

	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof AnimalPane) {
			for (AnimalPaneGUI animalGUI : myAnimalGUIList) {
				if (animalGUI.getAnimalPane() == o) {
					// System.out.println("BEGINNING ANIMATION in UPDATE");
					animation.beginAnimation(animalGUI);
				}
			}
		}
	}
	/*
	 * public Button CREATETESTBUTTON() { Button button = new Button("TESTER");
	 * button.setOnMouseClicked(e -> {
	 * System.out.println("setting coordinate map"); Random random = new
	 * Random(); List<Coordinate> list = new ArrayList<Point2D>(); list.add(new
	 * Coordinate(random.nextInt(LEFT_PANE_WIDTH - 15),
	 * random.nextInt(SCENE_HEIGHT*3/4 - 20))); list.add(new
	 * Point2D(random.nextInt(LEFT_PANE_WIDTH - 15),
	 * random.nextInt(SCENE_HEIGHT*3/4 - 20))); list.add(new
	 * Point2D(random.nextInt(LEFT_PANE_WIDTH - 15),
	 * random.nextInt(SCENE_HEIGHT*3/4 - 20))); list.add(new
	 * Point2D(random.nextInt(LEFT_PANE_WIDTH - 15),
	 * random.nextInt(SCENE_HEIGHT*3/4 - 20)));
	 * myAnimalPaneGUI.getAnimalPane().setCoordinateMap(list);
	 * myAnimalPaneGUI.getAnimalPane().getMyAnimalList().get(0).setHeading(40);
	 * }); return button; }
	 */

	public void setWorkspaceID(int id) {
		this.workSpaceID = id;
	}

	public BorderPane getMyRoot() {
		return myRoot;
	}

	public ResourceBundle getResources() {
		return myResources;
	}

	public void setResources(ResourceBundle resource) {
		this.myResources = resource;
	}

	public AnimalPaneGUI getAnimalPaneGUI() {
		return myAnimalPaneGUI;
	}

}
