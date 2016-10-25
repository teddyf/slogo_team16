package Controller;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
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
import model.command.ProcessCommand;

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
	private Animal turtle;
	public static final String FILEPATH = "Resources/myInput.slogo";

	public AnimalController() {
		file = new WriteFile();
		error = "";
		myProgramParser = new ProgramParser();
		myParserRunner = new ParserRunner("English", myProgramParser);
		turtle = null;
	}

	public void writeInputToFile(String input) {
		file.writeToFile(FILEPATH, input);
	}

	@Override
	public void handleInput() {
		try {
			runCommands();
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
			// TODO Auto-generated catch block
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

	private void runCommands() throws FileNotFoundException, NoSuchMethodException, SecurityException,
			ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchFieldException, InvalidLabelException {
		
		String[][] a = myParserRunner.combineAllLines();
		String[][] b = myParserRunner.markDepth(a);
		ExpressionTree tree = new ExpressionTree();
		tree.buildTree(b);
		ArrayList<TreeNode> node = tree.dfs();

		ProcessCommand pc = new ProcessCommand();
		double v = pc.process(this, turtle, tree.reverse(node));
		System.out.println(v);
		
		Coordinate coordinates = new Coordinate(turtle.getX(), turtle.getY(), turtle.getHeading());
		List<Coordinate> points = new ArrayList<Coordinate>();
		points.add(coordinates);
		activeAnimalPaneGUI.getAnimalPane().setCoordinateMap(points);
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
		this.turtle = activeAnimalPaneGUI.getAnimalPane().getMyAnimalList().get(0);
	}

	public void displayErrorDialog(String error) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Parsing error!");
		alert.setHeaderText("Invalid input displayed");
		alert.setContentText("Invalid input: " + error);
		alert.showAndWait();
	}

	// public void addAnimalPane(Workspace workspace) {
	// AnimalPane pane = new AnimalPane();
	// myAnimalPanes.add(pane);
	// workspace.add
	//
	// }

	// Evaluate expression, handle errors

}
