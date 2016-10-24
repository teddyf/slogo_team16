package model.command.turtle.visibility;

import model.animal.Animal;
import model.command.Parameter;

public class HideTurtle extends TurtleVisibility {

	public HideTurtle() {
		super();
		numParams = 1;
	}

	/**
	 * Makes the animal invisible
	 * @param params - array of parameters
	 * @return 0
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		return showTurtle(turtle, 0);
	}
}