package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.ResourceBundle;

import Controller.AnimalController;
import Controller.Controller;
import model.AnimalPane;
import model.animal.Animal;
import model.animal.Turtle;
import View.helper.Animate;
import View.helper.Buttons;
import View.helper.Console;
import View.helper.Graphics;
import View.tabs.CommandHistoryPane;
import View.tabs.ExampleCommandsPane;
import View.tabs.GenericPane;
import View.tabs.OptionsPane;
import View.tabs.VariablesPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
	public static final int SCENE_HEIGHT = 700;
	public static final int LEFT_PANE_WIDTH = SCENE_WIDTH - SCENE_WIDTH / 3;
	public static final int RIGHT_PANE_WIDTH = SCENE_WIDTH / 3 - 30;
	public static final int TURTLE_HEIGHT = 15;
	public static final int TURTLE_WIDTH = 15;
	public static final int BUTTON_WIDTH = 140;

	private static final String EN_RESRC_PATH = "resources/languages/English";
	private static final String CHI_RESRC_PATH = "resources/languages/Chinese";

	private BorderPane myRoot;
	// private AnimalPane myAnimalPane;
	private List<AnimalPaneGUI> myAnimalGUIList;
	private Buttons buttons;
	private Console console;
	private Animate animation;
	private ResourceBundle myResources;
	private Controller myController;
	private final GenericPane<String> historyPane = new CommandHistoryPane();
	private int workSpaceID;
	private SlogoView mainView;

	// There is only one instance of an AnimalPaneGUI per workspace
	private AnimalPaneGUI myAnimalPaneGUI;

	public Workspace(int workspaceID) {
		graphics = new Graphics();
		buttons = new Buttons();
		animation = new Animate();
		myAnimalGUIList = new ArrayList<>();
		myController = new AnimalController();
		myResources = ResourceBundle.getBundle(EN_RESRC_PATH);
		this.workSpaceID = workspaceID;
	}

	public void init(SlogoView view) {
		mainView = view;
		myRoot = new BorderPane();
		createAnimalPaneGUI();
		populateTopPane();
		populateLeftPane();
		populateRightPane();
	}

	public void createAnimalPaneGUI() {
		myAnimalPaneGUI = new AnimalPaneGUI();
		myAnimalGUIList.add(myAnimalPaneGUI);
		myAnimalPaneGUI.getAnimalPane().addObserver(this);
		// Need to switch? no? yes?
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

		Button tb = CREATETESTBUTTON();

		container.getChildren().addAll(title, languageComboBox, tb);
		myRoot.setTop(container);
	}

	private void populateLeftPane() {
		VBox leftPane = graphics.createVBoxPane(LEFT_PANE_WIDTH, SCENE_HEIGHT);
		leftPane.getStyleClass().add("left-pane");

		HBox container = createConsole();
		populateGridWithAnimals();

		leftPane.getChildren().addAll(myAnimalPaneGUI.getScrollPane(), container);
		myRoot.setLeft(leftPane);
	}

	private void populateRightPane() {
		// TODO: Jordan - inset magic numbers
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
		Tab tab = createTab(historyPane);
		return tab;
	}

	private Tab createOptionsTab() {
		// TODO: Jordan - passing in animalPaneGUI, need to update options pane
		GenericPane<HBox> pane = new OptionsPane(myAnimalPaneGUI, this);
		// to make custom ID buttons
		Tab tab = createTab(pane);
		return tab;
	}

	public HBox createConsole() {
		TextArea consoleArea = createConsoleArea();
		VBox buttons = createButtons();
		HBox consoleContainer = new HBox(5);
		consoleContainer.getChildren().addAll(consoleArea, buttons);
		return consoleContainer;
	}

	public TextArea createConsoleArea() {
		// TODO: Jordan - input correct width / height (doesn't matter)
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
		//createAnimal();
		renderAnimalGrid();
	}

	@Deprecated
	private void createAnimal() {
		Animal turtle = new Turtle(TURTLE_WIDTH, TURTLE_HEIGHT,
				(myAnimalPaneGUI.getScrollPane().getPrefWidth() - myAnimalPaneGUI.getScrollPane().getLayoutX() - 15)
						/ 2,
				(myAnimalPaneGUI.getScrollPane().getPrefHeight() - myAnimalPaneGUI.getScrollPane().getLayoutY()) / 2);
		myAnimalPaneGUI.addAnimal(turtle);
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
			System.out.println("NOT INSIDE ANIMAL PANE");
		}
	}

	private void addAnimalToGrid(Animal animal) {
//		Rectangle s = graphics.createRectCell(animal.getX(), animal.getY(), animal.getWidth(), animal.getHeight(),
//				Color.WHITE, Color.WHITE);
//		ImagePattern turtlePattern = new ImagePattern(animal.getImage());
//		s.setFill(turtlePattern);

		ImageView animalImage = animal.getImageView();
		animalImage.setFitHeight(TURTLE_HEIGHT);
		//turtleContainer.setStyle("-fx-background-color: #f12b92;"); //testing
		animalImage.setFitWidth(TURTLE_WIDTH);
		animalImage.setTranslateX(myAnimalPaneGUI.getScrollPane().getPrefWidth() / 2);
		animalImage.setTranslateY(myAnimalPaneGUI.getScrollPane().getPrefHeight() / 2);
		myAnimalPaneGUI.getMyContainer().getChildren().add(animalImage);

		// turtleContainer.getChildren().add(s);
		myAnimalPaneGUI.getScrollPane().setContent(myAnimalPaneGUI.getMyContainer());
	}

	// are we going to let turtle go off of the screen?
	private boolean isValidLocation(double x, double y) {
		return (x > myAnimalPaneGUI.getScrollPane().getLayoutX()) && (y > myAnimalPaneGUI.getScrollPane().getLayoutY())
				&& (x < myAnimalPaneGUI.getScrollPane().getPrefWidth())
				&& (y < myAnimalPaneGUI.getScrollPane().getPrefHeight());
	}

	public ComboBox<String> createLanguageChooser() {
		String[] languages = { "English", "Chinese", "French", "German", "Italian", "Portuguese", "Russian",
				"Spanish" };
		ComboBox<String> languageSelector = graphics.createComboBox(languages);
		languageSelector.setValue(languages[0]);
		languageSelector.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("combobox value is: " + newValue);
				if (newValue.equals("Chinese")) {
					myResources = ResourceBundle.getBundle(CHI_RESRC_PATH);
				} else if (newValue.equals("English")) {
					myResources = ResourceBundle.getBundle(EN_RESRC_PATH);
				}
				// etc
				// Loop through a list of all Text Values that should be updated
				// and update them?
				// currentText.setText(myResources.getString(currentText.getText()));
			}
		});
		return languageSelector;
	}

	@Override
	public void update(Observable o, Object arg) {


		if (o instanceof AnimalPane) {
			for (AnimalPaneGUI animalGUI : myAnimalGUIList) {
				if (animalGUI.getAnimalPane() == o) {
					// for (int animalId :
					// animalGUI.getAnimalPane().getMyAnimalMap().keySet()) {

					// for(Animal animal :
					// animalGUI.getAnimalPane().getMyAnimalList()) {
					// if(animal.getSelected()) {
					System.out.println("BEGINNING ANIMATION in UPDATE");
					animation.beginAnimation(animalGUI);
					// }
					// }
					// }
				}
			}
		}
	}

	public Button CREATETESTBUTTON() {
		Button button = new Button("TESTER");
		button.setOnMouseClicked(e -> {
			System.out.println("setting coordinate map");
			Random random = new Random();
			List<Point2D> list = new ArrayList<Point2D>();
			list.add(new Point2D(random.nextInt(LEFT_PANE_WIDTH - 15), random.nextInt(SCENE_HEIGHT*3/4 - 20)));
			list.add(new Point2D(random.nextInt(LEFT_PANE_WIDTH - 15), random.nextInt(SCENE_HEIGHT*3/4 - 20)));
			list.add(new Point2D(random.nextInt(LEFT_PANE_WIDTH - 15), random.nextInt(SCENE_HEIGHT*3/4 - 20)));
			list.add(new Point2D(random.nextInt(LEFT_PANE_WIDTH - 15), random.nextInt(SCENE_HEIGHT*3/4 - 20)));
			myAnimalPaneGUI.getAnimalPane().setCoordinateMap(list);
			myAnimalPaneGUI.getAnimalPane().getMyAnimalList().get(0).setHeading(40);
		});
		return button;
	}

	public void setWorkspaceID(int id) {
		this.workSpaceID = id;
	}

	public BorderPane getMyRoot() {
		return myRoot;
	}

}
