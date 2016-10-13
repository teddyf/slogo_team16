package View;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
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
	private String currentlyTypedWord;

	public Console(TextArea area) {
		this.console = area;
		currentlyTypedWord = "";
	}

	public void initConsole() {
		writeToConsole("Type your SLogo here");
		addListener();
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

	private void addListener() {
		console.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> observable, final String oldValue,
					final String newValue) {
				String[] words = newValue.split(" ?(?<!\\G)((?<=[^\\p{Punct}])(?=\\p{Punct})|\\b) ?");
				if (!nextCharIsSpace(newValue)) {
					currentlyTypedWord = words[words.length - 1];
				} else {
					currentlyTypedWord = words[words.length - 2];
				}
				System.out.println("Currently typed word: " + currentlyTypedWord);
				autoComplete(currentlyTypedWord);
			}
		});
	}

	private boolean nextCharIsSpace(String value) {
		return value.charAt(value.length() - 1) == ' ';
	}

	private void autoComplete(String currentWord) { // GUYS I FORGOT HOW TO USE
		String[] words = {"print","anime", "System.out.println"};											// TRIES
		for (int i = 0; i < words.length; i++) {
			if (currentWord.toLowerCase().contains(words[i].toLowerCase())){
				System.out.println("Autocomplete time!" );
			}
		}
	}
	
	private void createAutoCompleteOptions(String[] values){
		//ComboBox selections = new ComboBox();
		//selections.setItems(values);
	}
	
	private void eraseTextOnInitialClick() {
		console.setOnMouseClicked(e -> {
			console.clear();
			console.setOnMouseClicked(event -> {
				//do nothing after initial clear
			});
		});
	}

}