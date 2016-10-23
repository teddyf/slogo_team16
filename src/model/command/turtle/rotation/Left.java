package Model.command.turtle.rotation;

import Model.animal.Animal;

public class Left extends TurtleRotation {

	public Left(Animal turtle) {
		super(turtle);
	}

	/**
	 * Turns the animal clockwise by a specified number of degrees
	 * 
	 * @param degrees
	 *            - the specified number of degrees
	 * @return the number of degrees
	 */
	public double run(double degrees) {
		return turn(degrees, 1);
	}
}