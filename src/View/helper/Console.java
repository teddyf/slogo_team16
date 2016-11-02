package View.helper;

import javafx.scene.control.TextArea;

/**
 * Creates the console
 */
/**
 * @author Lucy Zhang
 *
 */
public class Console {
	private TextArea console;

	public Console() {
		this.console = new TextArea();
		writeToConsole("Type your SLogo here");
		eraseTextOnInitialClick();
	}

	public Console(TextArea area) {
		this.console = area;
		writeToConsole("Type your SLogo here");
		eraseTextOnInitialClick();
	}

	public void writeToConsole(String text) {
		console.appendText(text);
	}

	public String getInput() {
		return console.getText();
	}

	public void clearConsole() {
		console.clear();
	}

	
	
	private void eraseTextOnInitialClick() {
		console.setOnMouseClicked(e -> {
			console.clear();
			console.setOnMouseClicked(event -> {
				//do nothing after initial clear
			});
		});
	}
	
	public TextArea getConsoleArea() {
		return console;
	}

}