package Controller;

import java.util.List;
import java.util.Map;

import Model.AnimalPane;
import Parsing.Parser;
import View.AnimalPaneGUI;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * 
 * @author Jordan Frazier
 *
 */
// TODO: Jordan - update this when parser gets implemented
public class AnimalController implements Controller {
	
	private Parser parser;
	private String error;
	private List<AnimalPane> myAnimalPanes;
	private AnimalPane activeAnimalPane;
	private AnimalPaneGUI activeAnimalPaneGUI;

	public AnimalController() {
		parser = new Parser();
		error = "";
	}

	@Override
	public 	Map<Integer, String[]> handleInput(String input) {
		Map<Integer, String[]> parsedText = parser.parseInput(input);
		if (parsedText == null) {
			// Invalid input, display error dialog
			displayErrorDialog(input);
		} else {
			runCommands(parsedText);
		}
		return parsedText;
	}

	private void runCommands(Map<Integer, String[]> parsedText) {
		
	}

//	@Override
//	public AnimalPane getActiveAnimalPane() {
//		return activeAnimalPane;
//	}
	
//	@Override
//	public void setActiveAnimalPane(AnimalPane currentAnimalPane) {
//		this.activeAnimalPane = currentAnimalPane;
//	}
	
	// Could have this listening to the main view, and when user switches workspace, the active animal pane gui changes
	
	
	@Override
	public AnimalPaneGUI getActiveAnimalPaneGUI() {
		return activeAnimalPaneGUI;
	}
	
	@Override
	public void setActiveAnimalPaneGUI(AnimalPaneGUI currentAnimalPaneGUI) {
		this.activeAnimalPaneGUI = currentAnimalPaneGUI;
	}
	
	public void displayErrorDialog(String error) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Parsing error!");
		alert.setHeaderText("Invalid input displayed");
		alert.setContentText("Invalid input: " + error);
		alert.showAndWait();
	}
	
//	public void addAnimalPane(Workspace workspace) {
//		AnimalPane pane = new AnimalPane();
//		myAnimalPanes.add(pane);
//		workspace.add
//		
//	}

	// Evaluate expression, handle errors

}
