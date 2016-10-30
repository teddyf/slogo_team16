package model.command.turtle.movement;

import Parsing.ExpressionTree;
import model.animal.Animal;
import model.command.Parameter;

public class Forward extends TurtleMovement {
	private final double paramCount;
	
	public Forward() {
		super();
		numParams = 2;
		paramCount = 1;
	}

	/**
	 * Moves the animal forward in its current heading by a specified number of pixels
	 * @param params - array of parameters
	 * @return the number of pixels
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double pixels = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		return move(turtle, pixels);
	}
}
