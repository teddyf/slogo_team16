package View;

import java.util.Map;

import Parsing.Parser;
import View.tab_panes.GenericPane;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
	
	public VBox createConsoleInputButtons(Console console, GenericPane history){
		VBox container = new VBox(5);
		Button run = createRunButton(console, history);
		Button clear = createClearButton(console);
		container.getChildren().addAll(run, clear);
		return container;
	}
	
	private Button createRunButton(Console console, final GenericPane history) {
		Button run = graphic.createButton("Run");
		run.setOnAction(e -> {
			String input = console.getInput();
			// TODO: add more checks for empty input
			if (input.isEmpty()) {
				return;
			}
			
			System.out.println(input);
			//Add command to history, move this to only after its been checked for errors
			addCommandToHistory(history, input);
			
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
	
	private void addCommandToHistory(final GenericPane history, String input) {
		history.getItems().add(input);
		history.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			  public void handle(MouseEvent e) {
		        if(e.getButton().equals(MouseButton.PRIMARY)){
		            if(e.getClickCount() == 2){
//		    			//TODO: Jordan - Add run functionality to clicking
		    			System.out.println("clicked on " + history.getSelectionModel().getSelectedItem());
		            }
		        }
		    }
		});
	}

}
