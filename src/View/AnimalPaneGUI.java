package View;

import Model.AnimalPane;
import javafx.scene.layout.Pane;

public class AnimalPaneGUI {

	private AnimalPane animalPane;
	private Pane pane;
	
	public AnimalPaneGUI(AnimalPane animalPane) {
		this.animalPane = animalPane;
		pane = new Pane();
		
	}	
	
	public AnimalPane getAnimalPane() {
		return animalPane;
	}

	public Pane getPane() {
		return pane;
	}

	public void setAnimalPane(AnimalPane animalPane) {
		this.animalPane = animalPane;
	}

	public void setPane(Pane pane) {
		this.pane = pane;
	}
}
