package Model.command.turtle.rotation;

import Model.animal.Animal;

public class Towards extends TurtleRotation {

	public Towards(Animal turtle) {
		super(turtle);
	}

	/**
	 * Turns the animal to face an absolute screen position
	 * 
	 * @param x
	 *            - the specified x coordinate
	 * @param y
	 *            - the specified y coordinate
	 * @return the number of degrees moved
	 */
	public double run(double x, double y) {
		return turnTo(x, y);
	}
}