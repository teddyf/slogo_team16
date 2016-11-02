/**
 * This is the class for the TOWARDS command
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
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression)) 
				&& ((params[2].getNode().expression instanceof ConstantExpression) || (params[2].getNode().expression instanceof VariableExpression))) {
			double x = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			double y = ExpressionTree.getInstance().process(turtle, params[2].getNode());
			return turnTo(turtle, x, y);
		} else {
			Errors.getInstance().displayError("Data Type Error!", "Invalid Data Entered", 
					"The wrong type of input has been entered into the towards command.");
			return -1;
		}
	}
}