package Model.command.turtle.rotation;

import Model.animal.Animal;
import Model.command.turtle.movement.TurtleMovement;

public class SetXY extends TurtleMovement {

	public SetXY(Animal turtle) {
		super(turtle);
	}

	/**
	 * Moves the animal to an absolute screen position
	 * 
	 * @param x
	 *            - the specified x coordinate
	 * @param y
	 *            - the specified y coordinate
	 * @return the distance the turtle moved
	 */
	public double run(double x, double y) {
		return moveTo(x, y);
	}
}