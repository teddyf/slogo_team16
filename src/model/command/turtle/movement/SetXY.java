package model.command.turtle.movement;

import model.animal.Animal;
import model.command.Parameter;

public class SetXY extends TurtleMovement {

	private final double numParams = 3;
	
	public SetXY() {
		super();
	}

	/**
	 * Moves the animal to an absolute screen position
	 * @param params - array of parameters
	 * @return the distance the turtle moved
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double x = params[1].getValue();
		double y = params[2].getValue();
		return moveTo(turtle, x, y);
	}
}