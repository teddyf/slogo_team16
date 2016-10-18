package View;

import java.util.ArrayList;
import java.util.List;

import Model.AnimalPane;
import Model.animal.Animal;
import javafx.scene.control.ScrollPane;

public class AnimalPaneGUI {

	private AnimalPane myAnimalPane;
	private ScrollPane myScrollPane;
	private List<Animal> myAnimalList;
	
	public AnimalPaneGUI(AnimalPane animalPane) {
		myAnimalPane = animalPane;
		myScrollPane = new ScrollPane();
		myAnimalList = new ArrayList<>();
		stylePane();
	}	
	
	public void stylePane() {
		myScrollPane.setPrefWidth(Workspace.LEFT_PANE_WIDTH);
		myScrollPane.setPrefHeight(Workspace.SCENE_HEIGHT - Workspace.SCENE_HEIGHT / 4);
		myScrollPane.getStyleClass().add("animal-pane");
	}
	
	public void addAnimal(Animal animal) {
		myAnimalList.add(animal);
		getAnimalPane().addAnimal(animal);
	}
	
	public AnimalPane getAnimalPane() {
		return myAnimalPane;
	}

	public ScrollPane getScrollPane() {
		return myScrollPane;
	}

	public void setAnimalPane(AnimalPane animalPane) {
		myAnimalPane = animalPane;
	}

	public void setScrollPane(ScrollPane pane) {
		myScrollPane = pane;
	}

	public List<Animal> getMyAnimalList() {
		return myAnimalList;
	}

	public void setMyAnimalList(List<Animal> myAnimalList) {
		this.myAnimalList = myAnimalList;
	}
}
