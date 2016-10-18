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

	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	private List<Point2D> coordinatePairs;
	private int counter;
	private AnimalPaneGUI animalPaneGUI;
	private Pen pen;

	public void beginAnimation(AnimalPaneGUI animalPaneGUI) {
		this.animalPaneGUI = animalPaneGUI;
		counter = 0;
		coordinatePairs = animalPaneGUI.getAnimalPane().getCoordinateMap();

		// TODO: this might not work for multiple turtles
		for (Animal animal : animalPaneGUI.getAnimalPane().getMyAnimalList()) {
		
			translateAnimation(coordinatePairs.get(counter), animal);
		}
	}

	private void translateAnimation(Point2D point, Animal animal) {
		
		ImageView animalImage = animal.getImageView();
		
		pen = animal.getActualPen();
		pen.createLine(animalImage.getTranslateX(), animalImage.getTranslateY());
		animalPaneGUI.getMyContainer().getChildren().add(pen.getLineList().get(counter));
		pen.getLineList().get(counter).endXProperty().bind(animalImage.translateXProperty());
		pen.getLineList().get(counter).endYProperty().bind(animalImage.translateYProperty());
		
		
		TranslateTransition translation = new TranslateTransition(Duration.millis(1000), animalImage);
		// translation.setFromX(animal.getX());
		// translation.setFromY(animal.getY());
		// translation.setToX(point.getX());
		// translation.setToY(point.getY());
		System.out.println("trans X : " + animalImage.getTranslateX());
		System.out.println("trans Y : " + animalImage.getTranslateY());

		translation.setFromX(animalImage.getTranslateX());
		translation.setFromY(animalImage.getTranslateY());
		translation.setToX(point.getX());
		translation.setToY(point.getY());
		translation.setOnFinished(e -> {
			System.out.println("FInished, setting animal x and y" + animalImage.getTranslateX() + ", "
					+ animalImage.getTranslateY());
			animal.setX(point.getX());
			animal.setY(point.getY());

			pen.getLineList().get(counter).endXProperty().unbind();
			pen.getLineList().get(counter).endYProperty().unbind();
			counter++;
			if (counter >= coordinatePairs.size()) {
				// Do nothing, but maybe should do something with a boolean
			} else {
				// Call translate to do with the next set of points
				translateAnimation(coordinatePairs.get(counter), animal);
			}
		});
		translation.play();
	}

	/*
	 * public void handleTurtleAnimation(Animal turtle, SLogoView slogo) {
	 * KeyFrame frame1 = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e ->
	 * turtle.update()); KeyFrame[] frames = { frame1 };
	 * initAnimation(animation, frames); }
	 * 
	 * private void initAnimation(Timeline animation, KeyFrame[] frames) {
	 * animation.setCycleCount(Timeline.INDEFINITE); for (KeyFrame frame :
	 * frames) { animation.getKeyFrames().add(frame); } animation.play(); }
	 */

}
