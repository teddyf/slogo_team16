package View.helper;

import View.AnimalClick;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class TextInput {

	private TextField text;
	private HBox box;
	private Graphics graphics = new Graphics();

	public TextInput() {
		text = new TextField();
	}

	public TextField getText() {
		return text;
	}

	private String getInput() {
		return text.getText();
	}

	private void createGoButton(HBox box, AnimalClick animalClick, boolean liveTurtle) {
		Button button = graphics.createButton("Go");
		box.getChildren().add(button);
		button.setOnAction(e -> {
			String input = getInput();
			if (liveTurtle) {
				animalClick.setWeirdTurtle(input);
			} else {
				animalClick.setDeadTurtle(input);
			}

		});

	}

	public HBox getTextInputBox(AnimalClick animalClick, Label label) {
		this.box = new HBox();
		box.getChildren().addAll(label, text);
		createGoButton(box, animalClick, true);
		createGoButton(box, animalClick, false);
		return box;

	}

}
