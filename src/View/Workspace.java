package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import Controller.AnimalController;
import Controller.Controller;
import Controller.Data;
import View.helper.Animate;
import View.helper.Buttons;
import View.helper.Colors;
import View.helper.Console;
import View.helper.Graphics;
import View.helper.UIDataUpdate;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.AnimalPane;
import model.animal.Animal;

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

	private String currentLanguage;
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
	private VBox leftPane;

	private ComboBox<String> languageComboBox;

	private UIDataUpdate UIUpdate;
	private GenericPane<String> variablesPane;
	private Map<String, Integer> colors;
	// support for multiple turtles
	private int numTurtles;
	private ArrayList<String> turtleIDs = new ArrayList<String>();
	private AnimalClick animalClick;

	// one instance of an AnimalPaneGUI per workspace
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
		animalClick = new AnimalClick(myAnimalPaneGUI);
		currentLanguage = languages[0];

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
		Data.getInstance().setBackgroundColor(Colors.BLACK.getColorIdMap().get(color));
		numTurtles = 0;
		animalClick = new AnimalClick();
		createAnimalPaneGUI();
		animalClick = new AnimalClick(myAnimalPaneGUI);
		currentLanguage = languages[0];
	}

	/**
	 * Initializes a workspace
	 * 
	 * @param view
	 *            The main SlogoView
	 */
	public void init(SlogoView view) {
		mainView = view;
		myRoot = new BorderPane();
		populateTopPane();
		populateLeftPane();
		populateRightPane();
		changeAnimalBackgroundColor(defaultBackgroundColor);
		UIUpdate = new UIDataUpdate(this, (VariablesPane) this.variablesPane);
	}

	/**
	 * Creates the animal Pane GUI
	 */
	public void createAnimalPaneGUI() {
		myAnimalPaneGUI = new AnimalPaneGUI();
		myAnimalGUIList.add(myAnimalPaneGUI);
		myAnimalPaneGUI.getAnimalPane().addObserver(this);
		createAnimal();
		myController.setActiveAnimalPaneGUI(myAnimalPaneGUI);
	}

	/**
	 * Creates the animal pane that talks to the controller
	 * 
	 * @return the animal pane
	 */
	public AnimalPane createAnimalPane() {
		AnimalPane animalPane = new AnimalPane();
		animalPane.addObserver(this);
		return animalPane;
	}

	private void populateTopPane() {
		HBox container = new HBox(20);
		container.getStyleClass().add("top-pane");

		Text title = new Text(myResources.getString("SLogo"));
		title.getStyleClass().add("slogo-title");

		this.languageComboBox = createLanguageChooser();
		languageComboBox.getStyleClass().add("language-button");

		container.getChildren().addAll(title, languageComboBox);

		myRoot.setTop(container);
	}

	private void populateLeftPane() {
		leftPane = graphics.createVBoxPane(LEFT_PANE_WIDTH, SCENE_HEIGHT);
		leftPane.getStyleClass().add("left-pane");

		ScrollPane container = createConsole();

		leftPane.getChildren().addAll(myAnimalPaneGUI.getScrollPane(), container);
		myRoot.setLeft(leftPane);
	}

	public void resetLeftPane() {
		AnimalPaneGUI animalGUI = new AnimalPaneGUI();
		myAnimalPaneGUI = animalGUI;
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
		GenericPane<String> pane = new ExampleCommandsPane(console);
		Tab tab = createTab(pane);
		return tab;
	}

	private Tab createVariablesTab() {
		this.variablesPane = new VariablesPane(console);
		Tab tab = createTab(this.variablesPane);
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
		Tab tab = createTab(pane);
		return tab;
	}

	/**
	 * Creates the console textarea to input slogo code
	 * 
	 * @return the console pane
	 */
	public ScrollPane createConsole() {
		ScrollPane consolePane = new ScrollPane();
		VBox buttons = createButtons();
		HBox consoleContainer = new HBox(5);
		consoleContainer.getChildren().addAll(console.getConsoleArea(), buttons);
		consolePane.setContent(consoleContainer);
		return consolePane;
	}

	private VBox createButtons() {
		VBox container = buttons.createConsoleInputButtons(console, historyPane, mainView, this);
		return container;
	}

	/**
	 * Populates the slogo grid with turtle(s)
	 */
	public void populateGridWithAnimals() {
		renderAnimalGrid();
	}

	/**
	 * Creates the turtle animal
	 */
	public void createAnimal() {
		numTurtles++;
		Animal animal = myAnimalPaneGUI.addAnimal();
		Data.getInstance().addTurtle(animal);
		renderAnimal(animal);
	}

	/**
	 * Renders the animal grid with all the animals
	 */
	public void renderAnimalGrid() {
		for (Animal animal : myAnimalPaneGUI.getMyAnimalList()) {
			renderAnimal(animal);
		}
	}

	private void renderAnimal(Animal animal) {
		if (isValidLocation(animal.getX(), animal.getY())) {
			addAnimalToGrid(animal);
		} else {
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
		if (!myAnimalPaneGUI.getMyContainer().getChildren().contains(animalImage)) {
			myAnimalPaneGUI.getMyContainer().getChildren().add(animalImage);
		}
		myAnimalPaneGUI.getScrollPane().setContent(myAnimalPaneGUI.getMyContainer());
	}

	private boolean isValidLocation(double x, double y) {
		return (x > myAnimalPaneGUI.getScrollPane().getLayoutX()) && (y > myAnimalPaneGUI.getScrollPane().getLayoutY())
				&& (x < myAnimalPaneGUI.getScrollPane().getPrefWidth())
				&& (y < myAnimalPaneGUI.getScrollPane().getPrefHeight());
	}

	/**
	 * Changes the background color
	 * 
	 * @param color
	 *            The color as a string
	 */
	public void changeAnimalBackgroundColor(String color) {
		String hexColor = decodeColor(color);
		myAnimalPaneGUI.getMyContainer().setStyle("-fx-background-color: " + hexColor);
	}

	private String decodeColor(String color) {
		return Colors.BLACK.getColorMap().get(color);
	}

	/**
	 * Creates the language chooser drop down
	 * 
	 * @return
	 */
	public ComboBox<String> createLanguageChooser() {
		ComboBox<String> languageSelector = graphics.createComboBox(languages);
		languageSelector.setValue(languages[0]);
		languageSelector.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				myController.setParsingLanguage(newValue);
				setCurrentLanguage(newValue);
			}
		});
		return languageSelector;
	}

	/**
	 * Selects a language using the dropdown through code
	 * 
	 * @param language
	 *            the language as a string
	 */
	public void selectLanguageThroughUI(String language) {
		languageComboBox.getSelectionModel().select(language);
	}

	/**
	 * Clears and resets entire grid
	 */
	public void clearAndResetScreen() {
		console.clearConsole();
		this.resetLeftPane();
		this.createAnimal();

	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof AnimalPane) {
			for (AnimalPaneGUI animalGUI : myAnimalGUIList) {
				if (animalGUI.getAnimalPane() == o) {
					animation.beginAnimation(animalGUI, buttons.getRunButton());
				}
			}
			if (Data.getInstance().getClearScreen()) {
				this.clearAndResetScreen();
			}
		}
	}

	public AnimalClick getAnimalClick() {
		return animalClick;
	}

	public String getCurrentLanguage() {
		return currentLanguage;
	}

	public void setCurrentLanguage(String newLanguage) {
		this.currentLanguage = newLanguage;
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

	public List<String> getTurtleIDs() {
		return turtleIDs;
	}

	public ComboBox<String> getLanguageComboBox() {
		return languageComboBox;
	}

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
