package View;

import animal.Animal;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class DisplayVariable {
	
	private Label label;
	private TextField value;
	private HBox container;
	private Animal animal;
	
	// TODO: Jordan - setting display variables to X default
	// Possible to use reflection to choose method based on label? 
	public DisplayVariable(String label, Animal animal) {
		this.label = new Label(label);
		this.animal = animal;
		this.value = new TextField(String.valueOf(animal.getX()));
		this.container = new HBox(10);
		bindAnimalValue();
		addNodesToContainer();
	}

	private void bindAnimalValue() {
		
		value.textProperty().bindBidirectional(animal.getXProperty());

//		this.label.textProperty().addListener(e -> {
//			label.setText(String.valueOf(animal.getTranslateX()));
//		});
		
//		this.label.textProperty().bind(new SimpleStringProperty(String.valueOf(animal.getTranslateX())));
	}
	
	private void addNodesToContainer() {
		container.getChildren().addAll(label, value);
	}
	
	/** GETTERS **/
	public HBox getContainer() {
		return container;
	}

	public double getValue() {
		return Double.parseDouble(value.getText());
	}

	public Label getLabel() {
		return label;
	}

	/** SETTERS **/
	public void setLabel(String label) {
		this.label.setText(label);
	}

	public void setValue(double value) {
		this.value.setText(String.valueOf(value));
	}
	

}
