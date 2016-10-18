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

	public void beginAnimation(AnimalPane animalPane) {

		// Map<String, List<CoordinatePair>> coordinatePairs =
		// animal.getCoordinateMap();
		List<Point2D> coordinatePairs = animalPane.getCoordinateMap();
		for (Point2D point : coordinatePairs) {
			for (int i : animalPane.getMyAnimalMap().keySet()) {
				Animal animal = animalPane.getMyAnimalMap().get(i);
				
				if(!animal.getSelected()) {
					return;
				}
				
				ImageView animalImage = animal.getImageView();
				// TODO: Jordan: Time for translation
				TranslateTransition translation = new TranslateTransition(Duration.millis(500), animalImage);
				translation.setFromX(animal.getX());
				translation.setFromY(animal.getY());
				translation.setToX(point.getX());
				translation.setToY(point.getY());

				translation.setOnFinished(e -> {
					animal.setX(point.getX());
					animal.setY(point.getY());
				});

				translation.play();
			}
		}
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
