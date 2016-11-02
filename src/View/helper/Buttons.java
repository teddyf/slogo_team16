package View.helper;

import java.util.Map;
import java.util.Observable;

import Controller.Controller;
import Controller.DataSetup.DataOutput;
import View.AnimalPaneGUI;
import View.HomeSelection;
import View.SlogoView;
import View.Workspace;
import View.helpscreen.HelpScreen;
import View.tabs.GenericPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Handles buttons
 */
/**
 * @author Jordan Frazier
 * @author Lucy Zhang
 *
 */

public class Buttons extends Observable {
	private Graphics graphic = new Graphics();
	private HelpScreen helpPage = new HelpScreen();
	private Controller myController;
	private Button run;

	private String currentCommand;
	private Button resetButton;

	public Buttons(Controller controller) {
		myController = controller;
		currentCommand = "";
	}

	public Buttons() {
		
	}
	
	public Button getResetButton(){
		return this.resetButton;
	}

	public VBox createConsoleInputButtons(Console console, GenericPane<String> pane, SlogoView slogoView, Workspace wkspc) {
		VBox container = new VBox(5);
		run = createRunButton(console, pane);
		Button clear = createClearConsoleButton(console, slogoView);
		Button help = createHTMLHelpButton();
		container.getChildren().addAll(run, clear, help);
		return container;
	}

	private Button createRunButton(Console console, GenericPane<String> pane) {
		Button run = graphic.createButton("Run");
		run.setPrefWidth(Workspace.BUTTON_WIDTH);
		run.setOnAction(e -> {
			String input = console.getInput();
			// TODO: add more checks for empty input
			if (input.isEmpty()) {
				return;
			}
			myController.writeInputToFile(input);
			myController.handleInput();
			updateObservers(input);
		});
		return run;
	}

	private void updateObservers(String input) {
		currentCommand = input;
		setChanged();
		notifyObservers();
	}

	private Button createClearConsoleButton(Console console, SlogoView slogoView) {
		Button clear = graphic.createButton("Clear Console");
		clear.setPrefWidth(Workspace.BUTTON_WIDTH);
		clear.setOnAction(e -> {
			console.clearConsole();
		});
		return clear;
	}

	public Button resetAndClearScreenButton(Console console, SlogoView slogoView, AnimalPaneGUI animalPane) {
		this.resetButton = graphic.createButton("Reset Screen");
		resetButton.setPrefWidth(Workspace.BUTTON_WIDTH);
		resetButton.setOnAction(e -> {
			Workspace pane = slogoView.getCurrentWorkspace();
			pane.clearAndResetScreen();
		});
		return resetButton;
	}

	private Button createHTMLHelpButton() {
		Button help = graphic.createButton("Help");
		help.setPrefWidth(Workspace.BUTTON_WIDTH);
		help.setOnAction(e -> {
			helpPage.displayHelp();
		});
		return help;
	}

	public Button createNewWorkspaceButton(SlogoView slogoView) {
		Button wkspc = graphic.createButton("New Workspace");
		wkspc.setPrefWidth(Workspace.BUTTON_WIDTH);
		wkspc.setOnAction(e -> {
			slogoView.createNewWorkSpace();
		});
		return wkspc;
	}

	public Button createSaveWorkspaceButton(SlogoView slogoView) {
		Button wkspc = graphic.createButton("Save Workspace");
		wkspc.setPrefWidth(Workspace.BUTTON_WIDTH);
		wkspc.setOnAction(e -> {
			Map<String, String> data = slogoView.parseWorkspaceData();
			DataOutput dataOutput = new DataOutput(data.get("title") + "_out.xml", data);
		});
		return wkspc;
	}

	public Button createAddNumTurtlesButton(Workspace wkspc) {
		Button addTurtle = graphic.createButton("Add one annoying turtle");
		addTurtle.setPrefWidth(Workspace.BUTTON_WIDTH * 1.5);
		addTurtle.setOnAction(e -> {
			wkspc.createAnimal();
		});
		return addTurtle;
	}


	public Button newWorkspaceFromFileButton() {
		Button newWkspc = graphic.createButton("New Workspace from file");
		newWkspc.setPrefWidth(Workspace.BUTTON_WIDTH * 1.5);
		newWkspc.setOnAction(e -> {
			Stage s = new Stage();
			HomeSelection home = new HomeSelection(s);
			home.initHomeScreen();
		});
		return newWkspc;
	}

	public String getCurrentCommand() {
		return currentCommand;
	}
	
	public Button getRunButton() {
		return run;
	}
}
