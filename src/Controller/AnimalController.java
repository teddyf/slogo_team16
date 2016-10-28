package Controller;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import ErrorHandling.InvalidLabelException;
import View.AnimalPaneGUI;
import View.helper.Coordinate;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.AnimalPane;
import model.animal.Animal;
import model.command.Command;
import model.command.CommandProcessor;
import model.command.Parameter;

/**
 * 
 * @author Jordan Frazier
 * @author Lucy Zhang
 */

public class AnimalController implements Controller {

	private WriteFile file;
	private String error;
	private List<AnimalPane> myAnimalPanes;
	private AnimalPaneGUI activeAnimalPaneGUI;

	public static final String FILEPATH = "Resources/myInput.slogo";

	public AnimalController() {
		file = new WriteFile();
		error = "";
	}

	public void writeInputToFile(String input) {
		file.writeToFile(FILEPATH, input);
	}

	@Override
	public void handleInput() {
		try {
			for (int t = 0; t < activeAnimalPaneGUI.getAnimalPane().getMyAnimalList().size(); t++) {
				runCommands(activeAnimalPaneGUI.getAnimalPane().getMyAnimalList().get(t));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			displayErrorDialog(e.getMessage());
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidLabelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void runCommands(Animal turtle) throws FileNotFoundException, NoSuchMethodException, SecurityException,
			ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchFieldException, InvalidLabelException {

		CommandProcessor processor = new CommandProcessor();
		processor.run(turtle);
		ArrayList<Command> commands = processor.getCommands();
		ArrayList<Parameter[]> parameters = processor.getParameters();
		
		double value = 0;
		Command command;
		for (int i = 0; i < commands.size(); i++) {
			command = commands.get(i);
			value = command.run(parameters.get(i));
			
			Coordinate coordinates = new Coordinate(turtle.getX(), turtle.getY(), turtle.getHeading(), turtle.getPen(), turtle.getShowing());
			List<Coordinate> points = new ArrayList<Coordinate>();
			points.add(coordinates);
			activeAnimalPaneGUI.getAnimalPane().setCoordinateMap(points);
		}
		System.out.println("VALUE " + value);
	}

	// @Override
	// public AnimalPane getActiveAnimalPane() {
	// return activeAnimalPane;
	// }

	// @Override
	// public void setActiveAnimalPane(AnimalPane currentAnimalPane) {
	// this.activeAnimalPane = currentAnimalPane;
	// }

	// Could have this listening to the main view, and when user switches
	// workspace, the active animal pane gui changes

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
	
	public void setParsingLanguage(String language) {
		myProgramParser = new ProgramParser();
		myParserRunner = new ParserRunner(language, myProgramParser);
	}

	// public void addAnimalPane(Workspace workspace) {
	// AnimalPane pane = new AnimalPane();
	// myAnimalPanes.add(pane);
	// workspace.add
	//
	// }

	// Evaluate expression, handle errors

}
