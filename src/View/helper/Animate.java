package View.helper;

import java.util.List;

import Model.AnimalPane;
import Model.animal.Animal;
import View.Workspace;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
	private Timeline animation = new Timeline();
	private List<Point2D> coordinatePairs;
	private int counter;
	
	public void beginAnimation(AnimalPane animalPane) {

		counter = 0;
		// Map<String, List<CoordinatePair>> coordinatePairs =
		// animal.getCoordinateMap();
		coordinatePairs = animalPane.getCoordinateMap();
		Animal animal = animalPane.getMyAnimalList().get(0);
		ImageView animalImage = animal.getImageView();
		translateAnimation(coordinatePairs.get(counter), animal, animalImage);

//		for (Point2D point : coordinatePairs) {
//
//			System.out.println("new point : " + point.getX() + " , " + point.getY());
//			// for (Animal animal : animalPane.getMyAnimalList()) {
//			Animal animal = animalPane.getMyAnimalList().get(0);
//
//			if (!animal.getSelected()) {
//				return;
//			}
//
//			ImageView animalImage = animal.getImageView();
//			// TODO: Jordan: Fix Time for translation
//			translateAnimation(point, animal, animalImage);
//
//			// }
//		}
	}


	private void translateAnimation(Point2D point, Animal animal, ImageView animalImage) {
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
			counter++;
			if(counter >= coordinatePairs.size()) {
				// Do nothing
			} else {
				translateAnimation(coordinatePairs.get(counter), animal, animalImage);
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
