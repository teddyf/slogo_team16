/**
 * This is the class for the LOG command
 * 
 * @author Aninda Manocha
 */

package model.command.math.exponential;

import ErrorHandling.Errors;
import Parsing.ConstantExpression;
import Parsing.ExpressionTree;
import Parsing.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;

public class Log extends MathExponential {
	private final double paramCount;
	
	public Log() {
		super();
		numParams = 2;
		paramCount = 1;
	}

	/**
	 * Determines the value of the natural log of an expression
	 * @param params - array of parameters
	 * @return the value
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression))) {
			double expression = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			return log(expression);
		} else {
			Errors.getInstance().displayError("Data Type Error!", "Invalid Data Entered", 
					"The wrong type of input has been entered into the log command.");
			return -1;
		}
	}
}