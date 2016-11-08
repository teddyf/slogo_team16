package Controller;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ErrorHandling.Error;
import ErrorHandling.InvalidLabelException;
import Parsing.ParserRunner;
import Parsing.ProgramParser;
import Parsing.TreeNode;
import Parsing.expression.ExpressionTree;
import View.AnimalPaneGUI;
import View.helper.Coordinate;
import model.animal.Animal;

/**
 * This class is responsible for communication between the frontend and backend. Once input is entered into the console, it is 
 * sent to this class to be parsed and processed. This class runs commands and sends the results (turtle information or values)
 * to the frontend so that the display can be updated accordingly. 
 * 
 * @author Jordan Frazier
 * @author Aninda Manocha
 * @author Lucy Zhang
 */

public class AnimalController implements Controller {

	private WriteFile file;
	private AnimalPaneGUI activeAnimalPaneGUI;
	private ProgramParser myProgramParser;
	private ParserRunner myParserRunner;

	public static final String FILEPATH = "Resources/myInput.slogo";
	public static final String DEFAULT_LANGUAGE = "English";

	public AnimalController() {
		file = new WriteFile();
		setParsingLanguage(DEFAULT_LANGUAGE);
	}

	@Override
	public void writeInputToFile(String input) {
		file.writeToFile(FILEPATH, input);
	}

	@Override
	public void handleInput() {
			for (int t = 0; t < activeAnimalPaneGUI.getAnimalPane().getMyAnimalList().size(); t++) {
				try {
					runCommands(activeAnimalPaneGUI.getAnimalPane().getMyAnimalList().get(t));
				} catch (FileNotFoundException | NoSuchMethodException | SecurityException | ClassNotFoundException
						| InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchFieldException | InvalidLabelException e) {
					Error.getInstance().displayError("Parsing error!", "Invalid input displayed", "Invalid input: " + e.getMessage());
				}
			}
			activeAnimalPaneGUI.getAnimalPane().signalAnimation(); 
	}

	/**
	 * Runs the commands on a turtle and produces a set of points that map the results of the commands for animation
	 * @param turtle - the turtle to run the commands on
	 * @throws FileNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchFieldException
	 * @throws InvalidLabelException
	 */
	private double runCommands(Animal turtle) throws FileNotFoundException, NoSuchMethodException, SecurityException,
			ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchFieldException, InvalidLabelException {

		double value = 0;
		String[][] line = myParserRunner.combineAllLines();
		line = myParserRunner.parseWithGroups(line);
		String[][] markedLine = myParserRunner.markDepth(line);
		TreeNode root = ExpressionTree.getInstance().buildTree(markedLine);
		
		List<Coordinate> points = new ArrayList<Coordinate>();
		ExpressionTree.getInstance().setPoints(points);
		Data.getInstance().setNumTurtles(activeAnimalPaneGUI.getAnimalPane().getMyAnimalList().size());
		if (turtle.getSelected()) {
			value = ExpressionTree.getInstance().process(turtle, root);
		}
		Map<Integer, List<Coordinate>> mapPoints = new HashMap<>();
		mapPoints.put(turtle.getId(), points);
		activeAnimalPaneGUI.getAnimalPane().setCoordinateMap(mapPoints);
		return value;
	}

	// Could have this listening to the main view, and when user switches
	// workspace, the active animal pane gui changes

	/**
	 * Gets the animal pane interface corresponding to the active window
	 * @return the active animal pane interface
	 */
	@Override
	public AnimalPaneGUI getActiveAnimalPaneGUI() {
		return activeAnimalPaneGUI;
	}

	/**
	 * Sets the animal pane interface corresponding to the active window
	 * @return the new active animal pane interface
	 */
	@Override
	public void setActiveAnimalPaneGUI(AnimalPaneGUI currentAnimalPaneGUI) {
		this.activeAnimalPaneGUI = currentAnimalPaneGUI;
	}

	/**
	 * Sets the language of SLogo so that commands are read in this command (the default is set as English)
	 * @param language - the new language 
	 */
	@Override
	public void setParsingLanguage(String language) {
		myProgramParser = new ProgramParser();
		myParserRunner = new ParserRunner(language, myProgramParser);
	}
}
