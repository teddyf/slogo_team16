package model.command.turtle.movement;

import model.animal.Animal;
import model.command.Parameter;

public class Home extends TurtleMovement {

	private final double numParams = 1;
	
	public Home() {
		super();
	}

	/**
	 * Moves the animal to the center of the screen
	 * @param params - array of parameters
	 * @return the distance the turtle moved
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		return moveTo(turtle, 0,0);
	}
}