package View.helper;

import java.util.Observable;
import java.util.Observer;

import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import Model.animal.Animal;

/**
 * 
 * @author Jordan Frazier
 *
 */
public class DisplayVariable implements Observer {

	private Label label;
	private TextField value;
	private HBox container;
	private StringProperty animalProperty;
	private Animal animal;

	public DisplayVariable(String label, StringProperty animalProperty) {
		this.label = new Label(label);
		this.animalProperty = animalProperty;
		this.value = new TextField(String.valueOf(animalProperty.getValue()));
		
//		this.value.setOnKeyReleased(e -> {
//			if (e.getCode() == KeyCode.ENTER) {
//				// Should only fire off to turtle if hit enter? 
//			}
//		});
		
		this.container = new HBox(10);
		setStyleClasses();
		bindAnimalValue();
		addNodesToContainer();
	}

	private void setStyleClasses() {
		label.getStyleClass().add("label-variable");
		value.getStyleClass().add("display-variable");
	}

	/**
	 * Binds the textfield value to the animal's coordinate
	 */
	private void bindAnimalValue() {
		value.textProperty().bindBidirectional(animalProperty);
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

	@Override
	public void update(Observable o, Object arg) {
		// TODO: UPDATE OBSERVABLE
		
	}

}
