package View.helper;

import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class PenColor extends Observable {

	private String color;
	private String PEN_NAME = "Pen Color: ";
	private HBox container;
	private ComboBox<String> combobox;
	// private static final String[] COLORS = { Colors.BLACK.toString(),
	// Colors.BLUE.toString(), Colors.GREEN.toString(), Colors.RED.toString() };

	public PenColor() {
		createContainer();
	}

	private void createContainer() {
		container = new HBox(10);
		Label lbl = new Label(PEN_NAME);

		ObservableList<String> optionList = FXCollections.observableArrayList(Colors.BLACK.getAllColors());
		combobox = new ComboBox<>(optionList);
		combobox.setValue(Colors.BLACK.getAllColors()[0]);
		combobox.valueProperty().addListener(e -> {
			setChanged();
			notifyObservers();
		});
		
		container.getChildren().addAll(lbl, combobox);

	}
	
	public HBox getContainer() {
		return container;
	}
	
	public ComboBox<String> getComboBox() {
		return combobox;
	}

}
