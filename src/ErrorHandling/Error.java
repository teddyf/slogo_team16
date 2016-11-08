package ErrorHandling;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This class handles errors by displaying an error message that indicates the type of error and where it occurred.
 * 
 * @author Jordan Frazier
 * @author Aninda Manocha
 */

public class Error {
	private static final Error instance = new Error();
	private Error() {}
	
	/**
	 * Get the instance of this error class
	 * @return the instance
	 */
	public static Error getInstance() {
		return instance;
	}
	
	/**
	 * Displays a dialog to create an error
	 * @param errorTitle - title of error
	 * @param header - header text of the error box
	 * @param content - content text in the error box
	 */
	public void displayError(String errorTitle, String header, String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(errorTitle);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
}

