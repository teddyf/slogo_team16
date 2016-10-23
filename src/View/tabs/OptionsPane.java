package View.tabs;

import java.util.Observable;

import View.AnimalPaneGUI;
import View.helper.Colors;
import View.helper.Graphics;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

/**
 * 
 * @author Jordan Frazier
 *
 */
public class OptionsPane implements GenericPane<HBox> {

	private String displayName = "Options";
	private ListView<HBox> content;
	private Graphics graphics;
	private AnimalPaneGUI animalPaneGUI;

	private static final String X_COORDINATE = "x: ";
	private static final String Y_COORDINATE = "y: ";

	private static final String PEN_COLOR = "Pen Color: ";
	private static final String BACKGROUND_COLOR = "Background Color: ";

	private static final String[] COLORS = { Colors.BLUE.toString(), Colors.GREEN.toString(), Colors.RED.toString() };

	public OptionsPane(AnimalPaneGUI animalPaneGUI) {
		this.animalPaneGUI = animalPaneGUI;
		graphics = new Graphics();
		content = new ListView<>();
		// Maybe have to loop through all animals in animalPane to create custom
		// buttons for each turtle
		createAllOptions();
	}

	private void createAllOptions() {
//		HBox penColor = createComboBoxOption(PEN_COLOR, COLORS);
		PenColor penColor = new PenColor();
		penColor.addObserver(animalPaneGUI.getAnimalPane().getMyAnimalList().get(0).getActualPen());
		
		HBox backgroundColor = createComboBoxOption(BACKGROUND_COLOR, COLORS);
		// DisplayVariable displayX =
		// graphics.createDisplayVariable(X_COORDINATE, animal.getXProperty());
		// DisplayVariable displayY =
		// graphics.createDisplayVariable(Y_COORDINATE, animal.getYProperty());

		content.getItems().addAll(penColor.getContainer(), backgroundColor);
		// content.getItems().addAll(penColor, backgroundColor,
		// displayX.getContainer(), displayY.getContainer());
	}

	private HBox createComboBoxOption(String name, String[] options) {
		HBox container = new HBox(10);
		Label lbl = new Label(name);

		ObservableList<String> optionList = FXCollections.observableArrayList(options);
		ComboBox<String> combobox = new ComboBox<>(optionList);
		combobox.setValue(options[0]);

		container.getChildren().addAll(lbl, combobox);
		return container;
	}

	@Override
	public String getTabName() {
		return displayName;
	}

	@Override
	public void makeClickable() {

	}

	@Override
	public ObservableList<HBox> getAllItems() {
		return content.getItems();
	}

	@Override
	public ListView<HBox> getTabContent() {
		return this.content;
	}

}
