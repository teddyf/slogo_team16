/**
 * This is the class for the POWER command
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

public class Power extends MathExponential {
	private final double paramCount;
	
	public Power() {
		super();
		numParams = 3;
		paramCount = 2;
	}

	/**
	 * Determines the value of a base raised to the power of an exponent
	 * @param params - array of parameters
	 * @return - the value
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression)) 
				&& ((params[2].getNode().expression instanceof ConstantExpression) || (params[2].getNode().expression instanceof VariableExpression))) {
			double base = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			double exponent = ExpressionTree.getInstance().process(turtle, params[2].getNode());
			return power(base, exponent);
		} else {
			Errors.getInstance().displayError("Data Type Error!", "Invalid Data Entered", 
					"The wrong type of input has been entered into the power command.");
			return -1;
		}
	}
}