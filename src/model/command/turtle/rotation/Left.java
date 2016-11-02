/**
 * This is the class for the LEFT command
 * 
 * @author Aninda Manocha
 */

package model.command.turtle.rotation;

import ErrorHandling.Errors;
import Parsing.ConstantExpression;
import Parsing.ExpressionTree;
import Parsing.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;

public class Left extends TurtleRotation {
	private final double paramCount;
	
	public Left() {
		super();
		numParams = 2;
		paramCount = 1;
	}

	/**
	 * Turns the animal clockwise by a specified number of degrees
	 * @param params - array of parameters
	 * @return the number of degrees
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression))) {
			double degrees = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			return turn(turtle, degrees*-1, 1);
		} else {
			Errors.getInstance().displayError("Data Type Error!", "Invalid Data Entered", 
					"The wrong type of input has been entered into the left command.");
			return -1;
		}
	}
}