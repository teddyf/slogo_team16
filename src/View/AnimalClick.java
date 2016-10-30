package View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import View.helper.Graphics;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.animal.Animal;

public class AnimalClick {

	public static final String WEIRDTURTLE = "http://images.clipartpanda.com/turtle-clip-art-turtle6.png";

	public static final String DEADTURTLE = "http://vignette4.wikia.nocookie.net/penguindrum/images/e/ee/Mawaru_penguindrum_peng_head_by_gintabro-d3lj8vt.png/revision/latest?cb=20120304141806";
	// private Map<Animal, String> activeTurtles = new HashMap<Animal,
	// String>();
	private Graphics graphic = new Graphics();
	private ArrayList<Animal> activeTurtles; // = new ArrayList<Animal>();
	private AnimalPaneGUI animalPane;

	public AnimalClick(AnimalPaneGUI animalPane) {
		this.animalPane = animalPane;
		activeTurtles = (ArrayList<Animal>) animalPane.getMyAnimalList();
	}

	public void setEventListener(Animal animal) {
		animal.getImageView().setOnMouseClicked(event -> {
			updateAnimal(animal);
		});
	}

	private void updateAnimal(Animal animal) {
		if (isActiveAnimal(animal)) { // it's already active, so deactivate it
			// activeTurtles.remove(animal);
			animalPane.removeAnimal(animal);
			animal.getImageView().setStyle("-fx-image: url(\"" + DEADTURTLE + "\");");
		} else {
			// setActiveAnimal(animal);
			animalPane.addAnimal(animal);
			animal.getImageView().setStyle("-fx-image: url(\"" + WEIRDTURTLE + "\");");
			// setNewImage("turtleLogo.png",animal);
		}
		// animal.getImageView().setStyle("-fx-image: url(\""+ imageUrl +
		// "\");");
	}

	public ArrayList<Animal> getActiveTurtles() {
		animalPane.setMyAnimalList(activeTurtles);
		return activeTurtles;
	}

	public void setActiveTurtles(ArrayList<Animal> activeTurtles) {
		this.activeTurtles = activeTurtles;
	}

	public boolean isActiveAnimal(Animal animal) {
		return (activeTurtles.contains(animal));
	}
}
