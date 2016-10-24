package model.command.turtle.pen;

import model.animal.Animal;
import model.command.Parameter;

public class PenDown extends TurtlePen {

	public PenDown() {
		super();
		numParams = 1;
	}

	/**
	 * Puts pen down so that the animal leaves a trail when it moves
	 * @param params - array of parameters
	 * @return 1
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		return penDown(turtle, 1);
	}
}