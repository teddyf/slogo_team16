package Controller;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ErrorHandling.InvalidLabelException;
import Parsing.ExpressionTree;
import Parsing.ParserRunner;
import Parsing.ProgramParser;
import Parsing.TreeNode;
import View.AnimalPaneGUI;
import View.helper.Coordinate;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.AnimalPane;
import model.animal.Animal;

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
	private ProgramParser myProgramParser;
	private ParserRunner myParserRunner;

	public static final String FILEPATH = "Resources/myInput.slogo";
	public static final String DEFAULT_LANGUAGE = "English";


	public AnimalController() {
		file = new WriteFile();
		error = "";
		setParsingLanguage(DEFAULT_LANGUAGE);
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

		double value = 0;
		String[][] line = myParserRunner.combineAllLines();
		String[][] markedLine = myParserRunner.markDepth(line);
		TreeNode root = ExpressionTree.getInstance().buildTree(markedLine);
		
		List<Coordinate> points = new ArrayList<Coordinate>();
		ExpressionTree.getInstance().setPoints(points);
		value = ExpressionTree.getInstance().process(turtle, root);
		/*CommandProcessor processor = new CommandProcessor();
		processor.run(turtle);
		ArrayList<Command> commands = processor.getCommands();
		ArrayList<Parameter[]> parameters = processor.getParameters();
		Command command;
		for (int i = 0; i < commands.size(); i++) {
			command = commands.get(i);
			value = command.run(parameters.get(i));
			
			Coordinate coordinates = new Coordinate(turtle.getX(), turtle.getY(), turtle.getHeading(), turtle.getPen(), turtle.getShowing());
			List<Coordinate> points = new ArrayList<Coordinate>();
			points.add(coordinates);
			activeAnimalPaneGUI.getAnimalPane().setCoordinateMap(points);
		}*/
		System.out.println("VALUE " + value);
		/*System.out.println("TURTLE " + turtle.getX());
		Coordinate coordinates = new Coordinate(turtle.getX(), turtle.getY(), turtle.getHeading(), turtle.getPen(), turtle.getShowing());
		List<Coordinate> points = new ArrayList<Coordinate>();
		points.add(coordinates);*/
		Map<Integer, List<Coordinate>> mapPoints = new HashMap<>();
		mapPoints.put(turtle.getId(), points);
		activeAnimalPaneGUI.getAnimalPane().setCoordinateMap(mapPoints);

	}

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
