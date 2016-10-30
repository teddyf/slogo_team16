package model.command.turtle.movement;

import Parsing.ExpressionTree;
import model.animal.Animal;
import model.command.Parameter;

public class SetXY extends TurtleMovement {
	private final double paramCount;
	
	public SetXY() {
		super();
		numParams = 3;
		paramCount = 2;
	}

	/**
	 * Moves the animal to an absolute screen position
	 * @param params - array of parameters
	 * @return the distance the turtle moved
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double x = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		double y = ExpressionTree.getInstance().process(turtle, params[2].getNode());
		return moveTo(turtle, x, y);
	}
}