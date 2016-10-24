package model.command.turtle.movement;

import model.animal.Animal;
import model.command.Parameter;

public class ClearScreen extends TurtleMovement {
	private final double paramCount;
	
	public ClearScreen() {
		super();
		numParams = 1;
		paramCount = 1;
	}

	/**
	 * Erases the animal's trails and places it at the center of the screen
	 * @param params - array of parameters
	 * @return the distance the turtle moved
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		return moveTo(turtle, 0,0);
	}
}