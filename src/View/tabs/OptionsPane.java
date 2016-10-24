package View.tabs;

import java.util.HashMap;

import View.AnimalPaneGUI;
import View.Workspace;
import View.helper.Colors;
import View.helper.Graphics;
import View.helper.PenColor;
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
	private Graphics graphic = new Graphics();
	private Workspace workspace;

	private static final String X_COORDINATE = "x: ";
	private static final String Y_COORDINATE = "y: ";

	private static final String PEN_COLOR = "Pen Color: ";
	private static final String BACKGROUND_COLOR = "Background Color: ";

	private static final HashMap<String,String> colorHexVals = new HashMap<String,String>();
	
	private static final String[] COLORS = { Colors.BLUE.toString(), Colors.GREEN.toString(), Colors.RED.toString() };

	
	public OptionsPane(AnimalPaneGUI animalPaneGUI, Workspace workspace) {
		this.animalPaneGUI = animalPaneGUI;
		graphics = new Graphics();
		content = new ListView<>();
		this.workspace=workspace;
		// Maybe have to loop through all animals in animalPane to create custom
		// buttons for each turtle
		createAllOptions();
		populateColorHexVals();
	}

	private void populateColorHexVals(){
		colorHexVals.put(Colors.BLUE.toString(),"#0000ff");
		colorHexVals.put(Colors.GREEN.toString(),"#008000");
		colorHexVals.put(Colors.RED.toString(),"#ff0000");
		
	}
	private void createAllOptions() {
//		HBox penColor = createComboBoxOption(PEN_COLOR, COLORS);
		PenColor penColor = new PenColor();
		penColor.addObserver(animalPaneGUI.getAnimalPane().getMyAnimalList().get(0).getActualPen());
		//HBox penColor = createComboBoxOption(PEN_COLOR, COLORS);
		HBox backgroundColor = createBackgroundColorOptions();
				//createComboBoxOption(BACKGROUND_COLOR, COLORS);
				// DisplayVariable displayX =
		// graphics.createDisplayVariable(X_COORDINATE, animal.getXProperty());
		// DisplayVariable displayY =
		// graphics.createDisplayVariable(Y_COORDINATE, animal.getYProperty());

		content.getItems().addAll(penColor.getContainer(), backgroundColor);
//		content.getItems().addAll(penColor, backgroundColor);
//		content.getItems().addAll(/*penColor,*/ backgroundColor);
		// content.getItems().addAll(penColor, backgroundColor,
		// displayX.getContainer(), displayY.getContainer());
	}
	
	private HBox createBackgroundColorOptions(){
		ComboBox<String> colors = createComboBoxOption(COLORS);
		colors.valueProperty().addListener((o, old, neww) -> changeBackgroundColor(neww));
		HBox backgroundColor = setComboBoxInContainer(colors, BACKGROUND_COLOR);
		return backgroundColor;
	}

	private void createPenColor(){
		
	}

	private ComboBox<String> createComboBoxOption(String[] options) {
		
		//ObservableList<String> optionList = FXCollections.observableArrayList(options);
		ComboBox<String> combobox = graphic.createComboBox(options);
		//ComboBox<String> combobox = new ComboBox<>(optionList);
		combobox.setValue(options[0]);
		return combobox;
	}

	private HBox setComboBoxInContainer(ComboBox<String> box, String name){
		HBox container = new HBox(10);
		Label lbl = new Label(name);
		container.getChildren().addAll(lbl, box);
		return container;
	}
	
	private void changeBackgroundColor(String color){
		//change the color to the selected one
		System.out.println("CHange to this color: "+colorHexVals.get(color));
		//animalPaneGUI.getMyContainer().setStyle("-fx-background-color: "+colorHexVals.get(color)+";");
		animalPaneGUI.getScrollPane().setStyle("-fx-background-color: "+colorHexVals.get(color)+";");
		workspace.getMyRoot().setStyle("-fx-background-color: "+colorHexVals.get(color)+";");
		//animalPaneGUI.getScrollPane().getContent().setStyle("-fx-background-color: "+colorHexVals.get(color)+";");
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
