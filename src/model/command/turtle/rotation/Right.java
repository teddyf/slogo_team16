package model.command.turtle.rotation;

import model.animal.Animal;
import model.command.Parameter;

public class Right extends TurtleRotation {
	private final double paramCount;
	
	public Right() {
		super();
		numParams = 2;
		paramCount = 2;
	}

	/**
	 * Turns the animal counterclockwise by a specified number of degrees
	 * @param params - array of parameters
	 * @return the number of degrees
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double degrees = params[1].getValue();
		return turn(turtle, degrees, 0);
	}
}