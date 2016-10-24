package model.command.turtle.rotation;

import model.animal.Animal;
import model.command.Parameter;

public class Towards extends TurtleRotation {
	private final double paramCount;
	
	public Towards() {
		super();
		numParams = 3;
		paramCount = 3;
	}

	/**
	 * Turns the animal to face an absolute screen position
	 * @param params - array of parameters
	 * @return the number of degrees moved
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double x = params[1].getValue();
		double y = params[2].getValue();
		return turnTo(turtle, x, y);
	}
}