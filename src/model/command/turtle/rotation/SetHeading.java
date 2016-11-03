/**
 * This is the class for the SETHEADING command
 * 
 * @author Aninda Manocha
 */

package model.command.turtle.rotation;

import Parsing.ConstantExpression;
import Parsing.ExpressionTree;
import Parsing.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;

public class SetHeading extends TurtleRotation {
	private final double paramCount;
	
	public SetHeading() {
		super();
		numParams = 2;
		paramCount = 1;
	}

	/**
	 * Turns the animal to an absolute heading
	 * @param param - array of parameters
	 * @return the number of degrees moved
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression))) {
			double heading = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			return turnTo(turtle, heading);
		} else {
			super.commandInputError(this.getName());
			return -1;
		}
	}
}