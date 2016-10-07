package slogo_team16;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.Button;

public class Buttons {
	private Graphics graphic = new Graphics();
	
	public void createConsoleInputButton(Group root, Console console){
		Button button = graphic.createButton("Enter", 0, SLogoInterface.HEIGHT*1.5, root);
		button.setOnAction((ActionEvent e) -> {
			String input = console.getInput();
			System.out.println("Input: "+input);
		});
	}

}
