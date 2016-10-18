package Controller;

import java.util.List;
import java.util.Map;

import Model.AnimalPane;
import Parsing.Parser;

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
	private AnimalPane currentAnimalPane;

	public AnimalController() {
		parser = new Parser();
		error = "";
	}

	@Override
	public 	Map<Integer, String[]> handleInput(String input) {
		Map<Integer, String[]> parsedText = parser.parseInput(input);
		if (parsedText == null) {
			error = ("Invalid input: " + input);
		} else {
			runCommands(parsedText);
		}
		return parsedText;
	}

	private void runCommands(Map<Integer, String[]> parsedText) {
	
	}

	@Override
	public AnimalPane getActiveAnimalPane() {
		return currentAnimalPane;
	}
	
	public void setActiveAnimalPane(AnimalPane currentAnimalPane) {
		this.currentAnimalPane = currentAnimalPane;
	}
	
//	public void addAnimalPane(Workspace workspace) {
//		AnimalPane pane = new AnimalPane();
//		myAnimalPanes.add(pane);
//		workspace.add
//		
//	}

	// Evaluate expression, handle errors

}
