package View.tabs;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import View.AnimalPaneGUI;
import View.SlogoView;
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
 * @author lucyzhang
 *
 */
public class OptionsPane extends Observable implements GenericPane<HBox>  {

	private String displayName = "Options";
	private ListView<HBox> content;
	private Graphics graphics;
	private AnimalPaneGUI animalPaneGUI;
	private Graphics graphic = new Graphics();
	private Workspace workspace;
	private SlogoView slogoView;

	private static final String X_COORDINATE = "x: ";
	private static final String Y_COORDINATE = "y: ";
	private static final String PEN_COLOR = "Pen Color: ";
	private static final String BACKGROUND_COLOR = "Background Color: ";

	private static final Map<String,String> colorHexVals = new HashMap<String,String>();
	private static final String[] BACKGROUND_COLORS = { Colors.WHITE.toString(), Colors.BLACK.toString(), Colors.BLUE.toString(), Colors.GREEN.toString(), Colors.RED.toString() };


	public OptionsPane(){
		
	}
	
	public OptionsPane(AnimalPaneGUI animalPaneGUI, Workspace workspace, SlogoView mainView) {
		this.slogoView = mainView;
		this.animalPaneGUI = animalPaneGUI;
		graphics = new Graphics();
		content = new ListView<>();
		this.workspace=workspace;
		createAllOptions();
		populateColorHexVals();
	}
	
	private void populateColorHexVals(){
		for(Colors c : Colors.values() ){ 
			colorHexVals.put(c.toString(), c.getColor());
		}
		
//		colorHexVals.put(Colors.BLACK.toString(), Colors.BLACK.getColor());
//		colorHexVals.put(Colors.BLUE.toString(), Colors.BLUE.getColor());
//		colorHexVals.put(Colors.GREEN.toString(), Colors.GREEN.getColor());
//		colorHexVals.put(Colors.RED.toString(),Colors.RED.getColor());
		
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
		ComboBox<String> colors = createComboBoxOption(BACKGROUND_COLORS);
		colors.valueProperty().addListener((o, oldValue, newValue) -> workspace.changeAnimalBackgroundColor(newValue));
		HBox backgroundColor = setComboBoxInContainer(colors, BACKGROUND_COLOR);
		return backgroundColor;
	}

	private ComboBox<String> createComboBoxOption(String[] options) {
		
		//ObservableList<String> optionList = FXCollections.observableArrayList(options);
		ComboBox<String> combobox = graphic.createComboBox(options);
		// Sets default value to first value in list
		combobox.setValue(options[0]);
		return combobox;
	}

	private HBox setComboBoxInContainer(ComboBox<String> box, String name){
		HBox container = new HBox(10);
		Label lbl = new Label(name);
		container.getChildren().addAll(lbl, box);
		return container;
	}
	
//	public void changeBackgroundColor(String color){
//		slogoView.setBackgroundColor(color);
//		//change the color to the selected one
//		System.out.println("CHange to this color: "+colorHexVals.get(color));
//		//animalPaneGUI.getMyContainer().setStyle("-fx-background-color: "+colorHexVals.get(color)+";");
//		animalPaneGUI.getScrollPane().setStyle("-fx-background-color: "+colorHexVals.get(color)+";");
//		workspace.getMyRoot().setStyle("-fx-background-color: "+colorHexVals.get(color)+";");
//		//animalPaneGUI.getScrollPane().getContent().setStyle("-fx-background-color: "+colorHexVals.get(color)+";");
//	}

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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
