package View.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import Controller.Controller;
import Controller.DataSetup.DataOutput;
import View.AnimalPaneGUI;
import View.SlogoView;
import View.Workspace;
import View.helpscreen.HelpScreen;
import View.tabs.GenericPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.animal.Animal;

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

	private String currentCommand;

	public Buttons(Controller controller) {
		myController = controller;
		currentCommand = "";
	}

	public Buttons() {

	}

	public VBox createConsoleInputButtons(Console console, GenericPane<String> pane, SlogoView slogoView) {
		VBox container = new VBox(5);
		Button run = createRunButton(console, pane);
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

			System.out.println(input);
			// Add command to history, move this to only after its been checked
			// for errors
			// addCommandToHistory(pane, input);

			myController.writeInputToFile(input);
			myController.handleInput();
			// myController.checkForPrintCommand("print", console); // testing
			// the print
			// myController.checkForPrintCommand("print", console); // testing
			// the print
			// command

			// Updating Command History Pane with command
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
	
	public Button resetAndClearScreenButton(Console console, SlogoView slogoView, AnimalPaneGUI animalPane){
		Button clear = graphic.createButton("Reset Screen");
		clear.setPrefWidth(Workspace.BUTTON_WIDTH);
		clear.setOnAction(e -> {
			console.clearConsole();
			Workspace pane = slogoView.getCurrentWorkspaceLeftPane();
			pane.resetLeftPane();
			animalPane.resetMyAnimalList();
		});
		return clear;
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
			// System.out.println("main.getSlogoView(): "+main.getSlogoView());
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
		addTurtle.setPrefWidth(Workspace.BUTTON_WIDTH);
		addTurtle.setOnAction(e -> {
			wkspc.incrementNumTurtles();
		});
		return addTurtle;
	}

	public Button createDecrementNumTurtlesButton(Workspace wkspc) {
		Button minusTurtle = graphic.createButton("Get rid of one annoying turtle");
		minusTurtle.setPrefWidth(Workspace.BUTTON_WIDTH);
		minusTurtle.setOnAction(e -> {
			wkspc.decrementNumTurtles();
		});
		return minusTurtle;
	}

	@Deprecated
	private void addCommandToHistory(final GenericPane<String> pane, String input) {
		pane.getAllItems().add(input);
	}

	public String getCurrentCommand() {
		return currentCommand;
	}
}
