/**
 * This is the class for the DIFFERENCE command
 * 
 * @author Aninda Manocha
 */

package model.command.math.arithmetic;

import ErrorHandling.Errors;
import Parsing.ConstantExpression;
import Parsing.ExpressionTree;
import Parsing.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;

public class Difference extends MathArithmetic {
	private final double paramCount;
	
	public Difference() {
		super();
		numParams = 3;
		paramCount = 2;
	}

	/**
	 * Determines the difference of two values
	 * @param params - array of parameters
	 * @return the difference
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression)) 
				&& ((params[2].getNode().expression instanceof ConstantExpression) || (params[2].getNode().expression instanceof VariableExpression))) {
			double expression1 = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			double expression2 = ExpressionTree.getInstance().process(turtle, params[2].getNode());
			return sum(expression1, -expression2);
		} else {
			Errors.getInstance().displayError("Data Type Error!", "Invalid Data Entered", 
					"The wrong type of input has been entered into the difference command.");
			return -1;
		}
	}
}