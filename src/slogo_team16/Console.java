package slogo_team16;

import javafx.scene.control.TextArea;

public class Console{
	private TextArea console;

	public Console(TextArea area) {
		this.console = area;
	}

	public void writeToConsole(String text){
		console.appendText(text);
	}
	
	public String getInput(){
		return console.getText();
	}

}