package View.helper;

import java.util.List;

import Model.AnimalPane;
import Model.animal.Animal;
import View.AnimalPaneGUI;
import javafx.animation.TranslateTransition;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Handles animation
 */
/**
 * @author Lucy Zhang
 *
 */
public class Animate {

	private List<Point2D> coordinatePairs;
	private AnimalPaneGUI animalPaneGUI;
	private Pen pen;
	private int counter;

	public void beginAnimation(AnimalPaneGUI animalPaneGUI) {
		this.animalPaneGUI = animalPaneGUI;
		coordinatePairs = animalPaneGUI.getAnimalPane().getCoordinateMap();
		counter = 0;

		// TODO: will this work with multiple turtles
		for (Animal animal : animalPaneGUI.getAnimalPane().getMyAnimalList()) {
			pen = animal.getActualPen();
			translateAnimation(coordinatePairs.get(counter), animal);
		}
	}

	private void translateAnimation(Point2D point, Animal animal) {
		ImageView animalImage = animal.getImageView();
		handleRotation(animal, animalImage);
		bindPenToAnimal(animalImage);
		handleMovement(point, animal, animalImage);
	}

	private void handleMovement(Point2D point, Animal animal, ImageView animalImage) {
		TranslateTransition translation = new TranslateTransition(Duration.millis(1000), animalImage);
		System.out.println("trans X : " + animalImage.getTranslateX());
		System.out.println("trans Y : " + animalImage.getTranslateY());
		
		inputTranslationCoordinates(point, animalImage, translation);
		
		translation.setOnFinished(e -> {
			System.out.println("Finished, setting animal x and y" + animalImage.getTranslateX() + ", "
					+ animalImage.getTranslateY());
			
			updateAnimalCoordinates(point, animal);
			unbindPen();
			incrementCounters();
			if(counter < coordinatePairs.size()) {
				translateAnimation(coordinatePairs.get(counter), animal);
			}
		});
		translation.play();
	}

	private void inputTranslationCoordinates(Point2D point, ImageView animalImage, TranslateTransition translation) {
		translation.setFromX(animalImage.getTranslateX());
		translation.setFromY(animalImage.getTranslateY());
		translation.setToX(point.getX());
		translation.setToY(point.getY());
	}

	private void incrementCounters() {
		pen.incrementCounter();
		counter++;
	}

	private void updateAnimalCoordinates(Point2D point, Animal animal) {
		animal.setX(point.getX());
		animal.setY(point.getY());
	}

	private void unbindPen() {
		pen.getLineList().get(pen.getCounter()).endXProperty().unbind();
		pen.getLineList().get(pen.getCounter()).endYProperty().unbind();
	}

	private void handleRotation(Animal animal, ImageView animalImage) {
		animalImage.setRotate(animalImage.getRotate() + animal.getHeading());
	}

	private void bindPenToAnimal(ImageView animalImage) {
		pen.createLine(animalImage.getTranslateX(), animalImage.getTranslateY());
		animalPaneGUI.getMyContainer().getChildren().add(pen.getLineList().get(pen.getCounter()));
		pen.getLineList().get(pen.getCounter()).endXProperty().bind(animalImage.translateXProperty());
		pen.getLineList().get(pen.getCounter()).endYProperty().bind(animalImage.translateYProperty());
	}
}
