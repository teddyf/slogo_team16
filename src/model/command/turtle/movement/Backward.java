/**
 * This is the class for the BACKWARD command
 * 
 * @author Aninda Manocha
 */

package model.command.turtle.movement;

import ErrorHandling.Errors;
import Parsing.ConstantExpression;
import Parsing.ExpressionTree;
import Parsing.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;

public class Backward extends TurtleMovement {
	private final double paramCount;
	
	public Backward() {
		super();
		numParams = 2;
		paramCount = 1;
	}

	/**
	 * Moves the animal backward in its current heading by a specified number of pixels
	 * @param params - array of parameters
	 * @return the number of pixels
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression))) {
			double pixels = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			return move(turtle, pixels * -1)*-1;
		} else {
			Errors.getInstance().displayError("Data Type Error!", "Invalid Data Entered", 
					"The wrong type of input has been entered into the backward command.");
			return -1;
		}
	}
}