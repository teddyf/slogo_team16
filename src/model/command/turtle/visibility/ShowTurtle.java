package model.command.turtle.visibility;

import model.animal.Animal;
import model.command.Parameter;

public class ShowTurtle extends TurtleVisibility {

	private final double numParams = 1;
	
	public ShowTurtle() {
		super();
	}

	/**
	 * Makes the animal visible
	 * @param params - array of parameters
	 * @return 1
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		return showTurtle(turtle, 1);
	}
}