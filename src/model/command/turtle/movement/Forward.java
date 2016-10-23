package Model.command.turtle.movement;

import Model.animal.Animal;

public class Forward extends TurtleMovement {

	public Forward(Animal turtle) {
		super(turtle);
	}

	/**
	 * Moves the animal forward in its current heading by a specified number of
	 * pixels
	 * 
	 * @param pixels
	 *            - the specified number of pixels
	 * @return the number of pixels
	 */
	public double run(double pixels) {
		return move(pixels);
	}
}
