/**
 * This class contains methods to create dialog boxes for different types of errors;
 */

package ErrorHandling;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Errors {
	private static final Errors instance = new Errors();
	private Errors() {}
	
	/**
	 * Get the instance of this error class
	 * @return the instance
	 */
	public static Errors getInstance() {
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

