package View;

import java.io.File;
import java.util.List;

import Controller.DataSetup.DataSetup;
import View.helper.Graphics;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
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

	private String fileName;
	private DataSetup data;
	private final File INITIAL_DIRECTORY = new File("data");
	private final File IMAGE_DIRECTORY = new File("Resources");

	private Graphics graphic = new Graphics();
	private List<Animal> activeTurtles;
	private AnimalPaneGUI animalPane;

	public AnimalClick(AnimalPaneGUI animalPane) {
		this.animalPane = animalPane;
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
			updateAnimal(animal);
		});
	}

	private void updateAnimal(Animal animal) {
		if (animal.getSelected()) { // it's already active, so deactivate it
			animal.setSelected(false);
			// animal.getImageView().setStyle("-fx-image: url(\"" + DEADTURTLE +
			// "\");");
		} else {
			animal.setSelected(true);
			createFileDirectory(IMAGE_DIRECTORY, animal);
		}
	}

	private void updateAnimalImage(Animal animal, String fileName) {
		ImageView image = graphic.createImageView(graphic.createImage(fileName));
		animal.setImageView(image);
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

	private void createFileDirectory(File directory, Animal animal) {
		FileChooser chooser = new FileChooser();
		chooser.setInitialDirectory(directory);
		chooser.setTitle("Choose an image");
		File temp = chooser.showOpenDialog(new Stage());
		if (temp != null & directory.equals(IMAGE_DIRECTORY)) {
			fileName = temp.toString();
			data = new DataSetup(fileName);
			updateAnimalImage(animal, fileName);
		}
	}

}
