package Controller;

import java.util.List;
import java.util.Map;

import View.AnimalPaneGUI;
import model.AnimalPane;

/**
 * 
 * @author Jordan Frazier
 * @author Lucy Zhang
 */

public class AnimalController implements Controller {
	
	private WriteFile file;
	private String error;
	private List<AnimalPane> myAnimalPanes;
	private AnimalPane activeAnimalPane;
	private AnimalPaneGUI activeAnimalPaneGUI;
	public static final String FILEPATH = "Resources/myInput.slogo";

	public AnimalController() {
		file = new WriteFile();
		error = "";
	}

	public void writeInputToFile(String input){
		file.writeToFile(FILEPATH, input);
	}
	
	@Override
	public 	Map<Integer, String[]> handleInput(Map<Integer, String[]> parsedText) {
		
		//Map<Integer, String[]> parsedText = parser.parseInput(input);
		if (parsedText == null) {
			error = ("Invalid input: ");
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
	
	@Override
	public AnimalPaneGUI getActiveAnimalPaneGUI() {
		return activeAnimalPaneGUI;
	}
	
	@Override
	public void setActiveAnimalPaneGUI(AnimalPaneGUI currentAnimalPaneGUI) {
		this.activeAnimalPaneGUI = currentAnimalPaneGUI;
	}
	
//	public void addAnimalPane(Workspace workspace) {
//		AnimalPane pane = new AnimalPane();
//		myAnimalPanes.add(pane);
//		workspace.add
//		
//	}

	// Evaluate expression, handle errors

}
