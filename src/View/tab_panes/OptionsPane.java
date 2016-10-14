package View.tab_panes;

import View.Colors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OptionsPane implements GenericPane<HBox> {

	private String displayName = "Options";
	private ListView<HBox> content;
	
	private static final String PEN_COLOR = "Pen Color: ";
	private static final String BACKGROUND_COLOR = "Background Color: ";
	
	private static final String[] COLORS = {Colors.BLUE.toString(), Colors.GREEN.toString(), Colors.RED.toString()};

	public OptionsPane() {
		content = new ListView<>();
		createAllOptions();
	}
	
	private void createAllOptions() {
//		VBox container = new VBox(10);
		HBox penColor = createOption(PEN_COLOR, COLORS);
		HBox backgroundColor = createOption(BACKGROUND_COLOR, COLORS);
//		container.getChildren().addAll(penColor, backgroundColor);
		content.getItems().addAll(penColor, backgroundColor);
	}

	private HBox createOption(String name, String[] options) {
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
