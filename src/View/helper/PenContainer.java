package View.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import Controller.Data;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * The PenContainer is the container for the front end objects created that pertain to the Pen.
 * Currently, it houses the Pen Color, Pen Size/Width, and Pen Dash properties.
 * It is added as an observable to an animal in AnimalPane.
 * It is an observer of Data, which updates the properties of color, width/size, and dash value, whenever
 * backend updates Data class.
 * @author Jordan Frazier
 *
 */
public class PenContainer extends Observable implements Observer {

	private static final String PEN_COLOR = "Pen Color: ";
	private static final String PEN_WIDTH = "Pen Width: ";
	private static final String PEN_DASH = "Pen Dash: ";

	private String color;
	private HBox colorContainer;
	private HBox widthContainer;
	private HBox dashContainer;

	private Integer[] widthValues = { 1, 2, 3, 4, 5 };
	private String[] dashValues = { PenDash.SOLID.getName(), PenDash.DOTTED.getName(), PenDash.DASHED.getName() };
	private Map<String, Double> dashMap;

	private ComboBox<String> dashCombobox;
	private ComboBox<Integer> widthCombobox;
	private ComboBox<String> colorCombobox;

	// private static final String[] COLORS = { Colors.BLACK.toString(),
	// Colors.BLUE.toString(), Colors.GREEN.toString(), Colors.RED.toString() };

	public PenContainer() {
		Data.getInstance().addObserver(this);
		createColorContainer();
		createDashContainer();
		createWidthContainer();
	}

	// Jordan - Code Review : How to do this better
	public void populateDashMap() {
		dashMap = new HashMap<>();
		dashMap.put(PenDash.SOLID.getName(), PenDash.SOLID.getVal());
		dashMap.put(PenDash.DOTTED.getName(), PenDash.DOTTED.getVal());
		dashMap.put(PenDash.DASHED.getName(), PenDash.DASHED.getVal());
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
		// ObservableList<String> optionList =
		// FXCollections.observableArrayList(Colors.BLACK.getAllColors());
		// ComboBox<String> combobox = new ComboBox<>(optionList);
		// combobox.setValue(Colors.BLACK.getAllColors()[0]);
		// createContainer(widthContainer, label, combobox);
	}

	private void createDashBox() {
		String label = PEN_DASH;
		ObservableList<String> options = FXCollections.observableArrayList(dashValues);
		ComboBox<String> combobox = new ComboBox<String>(options);
		combobox.setValue(dashValues[0]);
		createContainer(widthContainer, label, combobox);
	}

	private void createWidthContainer() {
		widthContainer = new HBox(10);
		Label lbl = new Label(PEN_WIDTH);

		ObservableList<Integer> optionList = FXCollections.observableArrayList(widthValues);
		widthCombobox = new ComboBox<>(optionList);
		widthCombobox.setValue(widthValues[0]);
		widthCombobox.valueProperty().addListener(e -> {
			Data.getInstance().setPenSize(widthCombobox.getValue());
			setChanged();
			notifyObservers();
		});

		colorContainer.getChildren().addAll(lbl, widthCombobox);
	}

	private void createDashContainer() {
		populateDashMap();
		dashContainer = new HBox(10);
		Label lbl = new Label(PEN_DASH);

		ObservableList<String> optionList = FXCollections.observableArrayList(dashValues);
		dashCombobox = new ComboBox<>(optionList);
		dashCombobox.setValue(dashValues[0]);
		dashCombobox.valueProperty().addListener(e -> {
			Data.getInstance().setDashValue(dashMap.get(dashCombobox.getValue()));
			setChanged();
			notifyObservers();
		});

		colorContainer.getChildren().addAll(lbl, dashCombobox);
	}

	private void createColorContainer() {
		colorContainer = new HBox(10);
		Label lbl = new Label(PEN_COLOR);

		ObservableList<String> optionList = FXCollections.observableArrayList(Colors.BLACK.getAllColors());
		colorCombobox = new ComboBox<>(optionList);
		colorCombobox.setValue(Colors.BLACK.getAllColors()[0]);
		colorCombobox.valueProperty().addListener(e -> {
			Data.getInstance().setPenColor(Colors.valueOf(colorCombobox.getValue()).getId());
			setChanged();
			notifyObservers();
		});
		colorContainer.getChildren().addAll(lbl, colorCombobox);
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

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Data) {
			colorCombobox.setValue(Data.getInstance().getPenColor());
			widthCombobox.setValue((int)Data.getInstance().getPenSize());
			dashCombobox.setValue(PenDash.DOTTED.getIdMap().get(Data.getInstance().getDashValue()));
		}

	}

}
