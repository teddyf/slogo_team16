package View.helper;

import javafx.scene.control.TextArea;

/**
 * This class creates the console to type slogo code into
 * 
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

	/**
	 * Write text to console and have it appear in the console
	 * 
	 * @param text
	 */
	public void writeToConsole(String text) {
		console.appendText(text);
	}

	/**
	 * Gets the input of the text in the console
	 * 
	 * @return the string of input
	 */
	public String getInput() {
		return console.getText();
	}

	/**
	 * Clears the console
	 */
	public void clearConsole() {
		console.clear();
	}

	private void eraseTextOnInitialClick() {
		console.setOnMouseClicked(e -> {
			console.clear();
			console.setOnMouseClicked(event -> {
				// do nothing after initial clear
			});
		});
	}

	/**
	 * Get the console textarea
	 * 
	 * @return the console
	 */
	public TextArea getConsoleArea() {
		return console;
	}

}