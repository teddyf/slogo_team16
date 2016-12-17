package View;

import java.util.List;

import Controller.Controller;
import View.helper.Graphics;
import View.image_helper.ImageChooser;
import javafx.scene.input.MouseButton;
import model.animal.Animal;

/**
 * This class is responsible for the functionality behind clicking a turtle and
 * activating or deactivating it.
 * 
 * @author lucyzhang
 *
 */
public class AnimalClick {

	private String WEIRDTURTLE = "http://images.clipartpanda.com/turtle-clip-art-turtle6.png";

	private String DEADTURTLE = "http://vignette4.wikia.nocookie.net/penguindrum/images/e/ee/Mawaru_penguindrum_peng_head_by_gintabro-d3lj8vt.png/revision/latest?cb=20120304141806";

	private Graphics graphic = new Graphics();
	private List<Animal> activeTurtles;
	private Controller animalController;

	public AnimalClick(Controller animalPane) {
		this.animalController = animalPane;
	}

	public AnimalClick() {

	}

	/**
	 * Set the url of the active turtle image
	 * 
	 * @param url
	 */
	public void setWeirdTurtle(String url) {
		WEIRDTURTLE = url;
	}

	/**
	 * Set the url of the inactive turtle image
	 * 
	 * @param url
	 */
	public void setDeadTurtle(String url) {
		DEADTURTLE = url;
	}

	/**
	 * Set the event listener of the image
	 * 
	 * @param animal
	 *            the animal object
	 */
	public void setEventListener(Animal animal) {
		animal.getImageView().setOnMouseClicked(event -> {
			// if (event.getButton() == MouseButton.SECONDARY) {
			// openImageChooser();
			// } else {
			updateAnimal(animal);
			// }
		});
	}

	private void updateAnimal(Animal animal) {
		if (animal.getSelected()) { // it's already active, so deactivate it
			animal.setSelected(false);
			animal.getImageView().setStyle("-fx-image: url(\"" + DEADTURTLE + "\");");
		} else {
			animal.setSelected(true);
			animal.getImageView().setStyle("-fx-image: url(\"" + WEIRDTURTLE + "\");");
		}
	}

	public List<Animal> getActiveTurtles() {
		return activeTurtles;
	}

	public void setActiveTurtles(List<Animal> activeTurtles) {
		this.activeTurtles = activeTurtles;
	}

	/**
	 * Check if the animal is active
	 * 
	 * @param animal
	 * @return true if active, false if inactive
	 */
	public boolean isActiveAnimal(Animal animal) {
		return (activeTurtles.contains(animal));
	}
}
