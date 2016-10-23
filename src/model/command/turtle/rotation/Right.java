package Model.command.turtle.rotation;

import Model.animal.Animal;

public class Right extends TurtleRotation {

	public Right(Animal turtle) {
		super(turtle);
	}

	/**
	 * Turns the animal counterclockwise by a specified number of degrees
	 * 
	 * @param degrees
	 *            - the specified number of degrees
	 * @return the number of degrees
	 */
	public double run(double degrees) {
		return turn(degrees, 0);
	}
}