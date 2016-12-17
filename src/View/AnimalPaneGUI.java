package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.AnimalPane;
import model.animal.Animal;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * This class serves as the front end partner to AnimalPane. This class holds an
 * AnimalPane, and the front end components necessary to display the data in the
 * AnimalPane, such as a scrollpane and pane. This class is an observer of
 * AnimalPane, and should update, but as of now the functionality of updating is
 * implemented in Workspace.
 * 
 * @author Jordan Frazier
 * @author lucyzhang
 *
 */
public class AnimalPaneGUI implements Observer {

	private AnimalPane myAnimalPane;
	private ScrollPane myScrollPane;
	private List<Animal> myAnimalList;
	private Pane myContainer;

	public AnimalPaneGUI() {
		myAnimalList = new ArrayList<>();

		myAnimalPane = new AnimalPane();
		myAnimalPane.addObserver(this);

		myScrollPane = new ScrollPane();
		myContainer = new Pane();
		styleScrollPane();
		styleMyContainer();
	}

	public void styleScrollPane() {
		myScrollPane.setPrefWidth(Workspace.LEFT_PANE_WIDTH);
		myScrollPane.setPrefHeight(Workspace.SCENE_HEIGHT - Workspace.SCENE_HEIGHT / 4);
		myScrollPane.getStyleClass().add("animal-pane");
	}

	public void styleMyContainer() {
		myContainer.setPrefWidth(Workspace.LEFT_PANE_WIDTH);
		myContainer.setPrefHeight(Workspace.SCENE_HEIGHT - Workspace.SCENE_HEIGHT / 4);
	}

	public Animal addAnimal() {
		Animal animal = getAnimalPane().addAnimal();
		myAnimalList.add(animal);
		return animal;
	}

	public void removeAnimal(Animal animal) {
		myAnimalList.remove(animal);
		getAnimalPane().removeAnimal(animal);
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

	public void resetMyAnimalList() {
		myAnimalList.clear();
		getAnimalPane().clearAnimals();
	}

	public Pane getMyContainer() {
		return myContainer;
	}

	public void setMyContainer(Pane myContainer) {
		this.myContainer = myContainer;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof AnimalPane) {
			for (Animal an : ((AnimalPane) o).getMyAnimalList()) {
				System.out.println("ANIMAL ID: " + an.getId());
				addAnimalToGrid(an);
			}
		}

	}

	private void addAnimalToGrid(Animal animal) {
		ImageView animalImage = animal.getImageView();
		animalImage.setFitHeight(15);
		animalImage.setFitWidth(15);
		animalImage.setTranslateX(animal.getX());
		animalImage.setTranslateY(animal.getY());

		if (!myContainer.getChildren().contains(animalImage)) {
			myContainer.getChildren().add(animalImage);
		}

		myScrollPane.setContent(myContainer);
	}
}
