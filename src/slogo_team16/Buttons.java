package slogo_team16;

import java.util.Map;

import Parsing.Parser;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

/**
 * Handles buttons
 */
/**
 * @author Jordan Frazier
 * @author Lucy Zhang
 *
 */
public class Buttons {
	private Graphics graphic = new Graphics();
	private Parser parse = new Parser();
	
	public void createConsoleInputButtons(VBox container, Console console, ListView<String> history){
		Button run = createRunButton(console, history);
		Button clear = createClearButton(console);
		container.getChildren().addAll(run, clear);
	}
	
	private Button createRunButton(Console console, ListView<String> history) {
		Button run = graphic.createButton("Enter");
		run.setOnAction(e -> {
			String input = console.getInput();
			System.out.println(input);
			Map<Integer, String[]> map = parse.parseInput(input);
			parse.checkForPrintCommand("print", console); //testing the print command
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

}
