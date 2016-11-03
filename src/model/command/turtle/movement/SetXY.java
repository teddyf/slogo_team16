/**
 * This is the class for the SETXY command
 * 
 * @author Aninda Manocha
 */

package model.command.turtle.movement;

import Parsing.ConstantExpression;
import Parsing.ExpressionTree;
import Parsing.VariableExpression;
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
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression)) 
				&& ((params[2].getNode().expression instanceof ConstantExpression) || (params[2].getNode().expression instanceof VariableExpression))) {
			double x = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			double y = ExpressionTree.getInstance().process(turtle, params[2].getNode());
			return moveTo(turtle, x, y);
		} else {
			super.commandInputError(this.getName());
			return -1;
		}
	}
}