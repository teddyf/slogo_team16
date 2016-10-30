package model.command.turtle.rotation;

import Parsing.ExpressionTree;
import model.animal.Animal;
import model.command.Parameter;

public class Towards extends TurtleRotation {
	private final double paramCount;
	
	public Towards() {
		super();
		numParams = 3;
		paramCount = 2;
	}

	/**
	 * Turns the animal to face an absolute screen position
	 * @param params - array of parameters
	 * @return the number of degrees moved
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double x = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		double y = ExpressionTree.getInstance().process(turtle, params[2].getNode());
		return turnTo(turtle, x, y);
	}
}