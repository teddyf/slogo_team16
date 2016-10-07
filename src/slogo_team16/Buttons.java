package slogo_team16;

import java.util.Map;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.Button;
import Parsing.Parser;

/**
 * Handles buttons
 */
/**
 * @author Lucy Zhang
 *
 */
public class Buttons {
	private Graphics graphic = new Graphics();
	private Parser parse = new Parser();
	
	public void createConsoleInputButton(Group root, Console console){
		Button button = graphic.createButton("Enter", 0, SLogoInterface.HEIGHT*1.5, root);
		button.setOnAction((ActionEvent e) -> {
			//this is just printing the parse input
			String input = console.getInput();
			System.out.println(input);
			Map map = parse.parseInput(input);
			parse.checkForPrintCommand("print", console); //testing the print command

		});
	}

}
