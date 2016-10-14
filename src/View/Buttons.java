package View;

import java.util.Map;

import Parsing.Parser;
import View.tabs.GenericPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Handles buttons
 */
/**
 * @author Jordan Frazier
 * @author Lucy Zhang
 *
 */


//TODO: Jordan - Bind the history to a data set of history commands instead of passing in the pane. 
// also, add the commands to the input area instead of running them immediately on double click
public class Buttons {
	private Graphics graphic = new Graphics();
	private Parser parse = new Parser();

	public VBox createConsoleInputButtons(Console console, final GenericPane<String> pane) {
		VBox container = new VBox(5);
		Button run = createRunButton(console, pane);
		Button clear = createClearButton(console);
		container.getChildren().addAll(run, clear);
		return container;
	}

	private Button createRunButton(Console console, final GenericPane<String> pane) {
		Button run = graphic.createButton("Run");
		run.setOnAction(e -> {
			String input = console.getInput();
			// TODO: add more checks for empty input
			if (input.isEmpty()) {
				return;
			}

			System.out.println(input);
			// Add command to history, move this to only after its been checked
			// for errors
			addCommandToHistory(pane, input);

			Map<Integer, String[]> map = parse.parseInput(input);
			parse.checkForPrintCommand("print", console); // testing the print
															// command
		});
		return run;
	}

	private Button createClearButton(Console console) {
		Button clear = graphic.createButton("Clear");
		clear.setOnAction(e -> {
			console.clearConsole();
		});
		return clear;
	}

	private void addCommandToHistory(final GenericPane<String> pane, String input) {
		pane.getAllItems().add(input);
	}
}
