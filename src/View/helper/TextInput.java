package View.helper;

import View.AnimalClick;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class TextInput {

	private Graphics graphics = new Graphics();

	public TextInput() {
	}

	private String getInput(TextField text) {
		return text.getText();
	}

	private void createGoButton(HBox box, AnimalClick animalClick, boolean liveTurtle, TextField text) {
		Button button = graphics.createButton("Go");
		box.getChildren().add(button);
		button.setOnAction(e -> {
			String input = getInput(text);
			if (liveTurtle) {
				animalClick.setWeirdTurtle(input);
			} else {
				animalClick.setDeadTurtle(input);
			}

		});

	}

	public HBox getTextInputBox(AnimalClick animalClick, String label, boolean liveTurtle) {
		TextField text = new TextField();
		HBox box = new HBox();
		text.setPromptText(label);
		box.getChildren().add(text);
		createGoButton(box, animalClick, liveTurtle, text);
		return box;

	}

}
