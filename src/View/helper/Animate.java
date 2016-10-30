package View.helper;

import java.util.List;
import java.util.Map;

import View.AnimalPaneGUI;
import javafx.animation.TranslateTransition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.animal.Animal;

/**
 * Handles animation
 */
/**
 * @author Lucy Zhang, Jordan Frazier
 *
 */
public class Animate {

//	private List<Coordinate> coordinatePairs;
	private AnimalPaneGUI animalPaneGUI;
	// private Pen pen;
	// private int counter;

	// decrease this to speed up, increase to slow down
	private double SPEED = 1;

	public void beginAnimation(AnimalPaneGUI animalPaneGUI) {
		this.animalPaneGUI = animalPaneGUI;
		
		Map<Integer, List<Coordinate>> coordinatePairs = animalPaneGUI.getAnimalPane().getCoordinateMap();
		
		for(Integer id : coordinatePairs.keySet()) {
			Animal animal = animalPaneGUI.getAnimalPane().getMyAnimalMap().get(id);
			if (!animal.getSelected()) {
				continue;
			}
			IntegerProperty counter = new SimpleIntegerProperty();
			Pen pen = animal.getActualPen();
			pen.getLineList().clear();
			pen.resetCounter();

			Coordinate coordinatePoint = animalPaneGUI.getAnimalPane().getCoordinateMap().get(animal.getId()).get(counter.get());
			translateAnimation(coordinatePoint, animal, pen, counter, coordinatePairs.get(animal.getId()));
			
		}
	}

	private void translateAnimation(Coordinate coordinate, Animal animal, Pen pen, IntegerProperty counter, List<Coordinate> coordinatePairs) {
		ImageView animalImage = animal.getImageView();
		bindPenToAnimal(animalImage, coordinate, pen);
		changeAnimalVisibility(animalImage, coordinate);
		changeAnimalHeading(coordinate, animalImage);
		changeAnimalPosition(coordinate, animal, animalImage, pen, counter, coordinatePairs);
	}

	public void changeAnimalVisibility(ImageView animalImage, Coordinate coordinate) {
		animalImage.setVisible(coordinate.getShowing() != 0);
	}

	private void changeAnimalPosition(Coordinate point, Animal animal, ImageView animalImage, Pen pen,
			IntegerProperty counter, List<Coordinate> coordinatePairs) {
		TranslateTransition translation = new TranslateTransition(Duration.millis(getTranslateTime(point, animalImage)),
				animalImage);

		inputTranslationCoordinates(point, animalImage, translation);

		translation.setOnFinished(e -> {
			updateAnimalCoordinates(point, animal);
			unbindPen(point, pen);
			incrementCounters(point, pen, counter);
			if (counter.get() < coordinatePairs.size()) {
				translateAnimation(coordinatePairs.get(counter.get()), animal, pen, counter, coordinatePairs);
			}
		});
		translation.play();
	}

	private void inputTranslationCoordinates(Coordinate point, ImageView animalImage, TranslateTransition translation) {
		translation.setFromX(animalImage.getTranslateX());
		translation.setFromY(animalImage.getTranslateY());
		translation.setToX(point.getX());
		translation.setToY(point.getY());
	}

	private void incrementCounters(Coordinate coordinate, Pen pen, IntegerProperty counter) {
		if (coordinate.getPen() == 1) {
			pen.incrementCounter();
		}
		counter.set(counter.get() + 1);
	}

	private void updateAnimalCoordinates(Coordinate point, Animal animal) {
		animal.setX(point.getX());
		animal.setY(point.getY());
	}

	private void unbindPen(Coordinate coordinate, Pen pen) {
		if (coordinate.getPen() == 1 && (pen.getLineList().size() - 1 >= pen.getCounter())) {
			pen.getLineList().get(pen.getCounter()).endXProperty().unbind();
			pen.getLineList().get(pen.getCounter()).endYProperty().unbind();
		}
	}

	private void changeAnimalHeading(Coordinate coordinate, ImageView animalImage) {
		animalImage.setRotate(coordinate.getHeading());
	}

	private void bindPenToAnimal(ImageView animalImage, Coordinate coordinate, Pen pen) {
		if (coordinate.getPen() == 1) {
			pen.createLine(animalImage.getTranslateX(), animalImage.getTranslateY());
			animalPaneGUI.getMyContainer().getChildren().add(pen.getLineList().get(pen.getCounter()));
			pen.getLineList().get(pen.getCounter()).endXProperty().bind(animalImage.translateXProperty());
			pen.getLineList().get(pen.getCounter()).endYProperty().bind(animalImage.translateYProperty());
		}
	}

	private Double getTranslateTime(Coordinate point, ImageView turtle) {
		double oldx = turtle.getTranslateX();
		double oldy = turtle.getTranslateY();
		double newx = point.getX();
		double newy = point.getY();

		double distance = Math.sqrt(Math.pow((int) newx - oldx, 2) + Math.pow((int) newy - oldy, 2));
		Double time = distance * SPEED;
		return time;
	}
}
