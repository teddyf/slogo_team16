package Model.command.turtle.rotation;

import Model.animal.Animal;

public class SetHeading extends TurtleRotation {

	public SetHeading(Animal turtle) {
		super(turtle);
	}

	/**
	 * Turns the animal to an absolute heading
	 * 
	 * @param heading
	 *            - the absolute heading
	 * @return the number of degrees moved
	 */
	public double run(double heading) {
		return turnTo(heading);
	}
}