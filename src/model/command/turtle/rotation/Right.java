package model.command.turtle.rotation;

import Parsing.ExpressionTree;
import model.animal.Animal;
import model.command.Parameter;

public class Right extends TurtleRotation {
	private final double paramCount;
	
	public Right() {
		super();
		numParams = 2;
		paramCount = 1;
	}

	/**
	 * Turns the animal counterclockwise by a specified number of degrees
	 * @param params - array of parameters
	 * @return the number of degrees
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double degrees = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		return turn(turtle, degrees, 0);
	}
}