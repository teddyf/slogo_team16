package View.helper;

import java.util.Observable;

import Controller.Data;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class PenContainer extends Observable {
	
	private static final String PEN_COLOR = "Pen Color: ";
	private static final String PEN_WIDTH = "Pen Width: ";
	private static final String PEN_DASH = "Pen Dash: ";
	
	private String color;
	private HBox colorContainer;
	private HBox widthContainer;
	private HBox dashContainer;
	
	private String[] dashValues = {"Solid", "Dotted", "Dashed"};
	
	private ComboBox<String> combobox;
	// private static final String[] COLORS = { Colors.BLACK.toString(),
	// Colors.BLUE.toString(), Colors.GREEN.toString(), Colors.RED.toString() };

	public PenContainer() {
		createColorContainer();
	}
	
	private void createContainer(HBox container, String label, ComboBox<String> selector) {
		container = new HBox(10);
		Label lbl = new Label(label);
		
		selector.valueProperty().addListener(e -> {
			setChanged();
			notifyObservers();
		});
		container.getChildren().addAll(lbl, selector);
	}
	
	private void createPenColorBox() {
		String label = PEN_COLOR;
		ObservableList<String> optionList = FXCollections.observableArrayList(Colors.BLACK.getAllColors());
		ComboBox<String> combobox = new ComboBox<>(optionList);
		combobox.setValue(Colors.BLACK.getAllColors()[0]);
		createContainer(colorContainer, label, combobox);
	}
	
	private void createWidthBox() {
		String label = PEN_WIDTH;
//		ObservableList<String> optionList = FXCollections.observableArrayList(Colors.BLACK.getAllColors());
//		ComboBox<String> combobox = new ComboBox<>(optionList);
//		combobox.setValue(Colors.BLACK.getAllColors()[0]);
		createContainer(widthContainer, label, combobox);
	}
	
	private void createDashBox() {
		String label = PEN_DASH;
		ObservableList<String> options = FXCollections.observableArrayList(dashValues);
		ComboBox<String> combobox = new ComboBox<String>(options);
		combobox.setValue(dashValues[0]);
		createContainer(widthContainer, label, combobox);
	}


	private void createColorContainer() {
		colorContainer = new HBox(10);
		Label lbl = new Label(PEN_COLOR);

		ObservableList<String> optionList = FXCollections.observableArrayList(Colors.BLACK.getAllColors());
		combobox = new ComboBox<>(optionList);
		combobox.setValue(Colors.BLACK.getAllColors()[0]);
		combobox.valueProperty().addListener(e -> {
//			Data.getInstance().setPenColor();
			setChanged();
			notifyObservers();
		});
		
		colorContainer.getChildren().addAll(lbl, combobox);
	}
	
	public HBox getColorContainer() {
		return colorContainer;
	}
	
	public HBox getWidthContainer() {
		return widthContainer;
	}
	
	public HBox getDashContainer() {
		return dashContainer;
	}
	
	public ComboBox<String> getComboBox() {
		return combobox;
	}

}
