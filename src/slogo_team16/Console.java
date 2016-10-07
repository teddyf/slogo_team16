package slogo_team16;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

	public Console(TextArea area) {
		this.console = area;
	}
	
	public void initConsole(){
		writeToConsole("Type your SLogo here");
		addListener();
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

	private void addListener(){
		console.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
		        System.out.println("Stuff in console changed");
		        System.out.println("Old: "+oldValue);
		        System.out.println("New: "+newValue);
		    }
		});
	}

}