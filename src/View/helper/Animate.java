package View.helper;

import Model.animal.Animal;
import View.SLogoView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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

	public void handleTurtleAnimation(Animal turtle, SLogoView slogo) {
		KeyFrame frame1 = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> turtle.update());
		KeyFrame[] frames = { frame1 };
		initAnimation(animation, frames);
	}

	private void initAnimation(Timeline animation, KeyFrame[] frames) {
		animation.setCycleCount(Timeline.INDEFINITE);
		for (KeyFrame frame : frames) {
			animation.getKeyFrames().add(frame);
		}
		animation.play();
	}

}
