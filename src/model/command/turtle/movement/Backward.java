package Model.command.turtle.movement;

import Model.animal.Animal;

public class Backward extends TurtleMovement {

	public Backward(Animal turtle) {
		super(turtle);
	}

	/**
	 * Moves the animal backward in its current heading by a specified number of
	 * pixels
	 * 
	 * @param pixels
	 *            - the specified number of pixels
	 * @return the number of pixels
	 */
	public double run(double pixels) {
		return move(pixels * -1);
	}
}