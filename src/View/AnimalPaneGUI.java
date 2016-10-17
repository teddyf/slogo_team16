package View;

import Model.AnimalPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class AnimalPaneGUI {

	private AnimalPane animalPane;
	private ScrollPane pane;
	
	public AnimalPaneGUI(AnimalPane animalPane) {
		this.animalPane = animalPane;
		pane = new ScrollPane();
		
	}	
	
	public AnimalPane getAnimalPane() {
		return animalPane;
	}

	public ScrollPane getPane() {
		return pane;
	}

	public void setAnimalPane(AnimalPane animalPane) {
		this.animalPane = animalPane;
	}

	public void setPane(ScrollPane pane) {
		this.pane = pane;
	}
}
