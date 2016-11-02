/**
 * This is the class for the OR command
 * 
 * @author Aninda Manocha
 */

package model.command.booleans.logic;

import ErrorHandling.Errors;
import Parsing.ConstantExpression;
import Parsing.ExpressionTree;
import Parsing.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;

public class Or extends BooleanLogic {
	private final double paramCount;
	
	public Or() {
		super();
		numParams = 3;
		paramCount = 2;
	}

	/**
	 * Determines logical or of two test values
	 * @param params - array of parameters
	 * @return 1 if value 1 or value 2 are non-zero
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression)) 
				&& ((params[2].getNode().expression instanceof ConstantExpression) || (params[2].getNode().expression instanceof VariableExpression))) {
			double test1 = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			double test2 = ExpressionTree.getInstance().process(turtle, params[2].getNode());
			return or(test1, test2);
		} else {
			Errors.getInstance().displayError("Data Type Error!", "Invalid Data Entered", 
					"The wrong type of input has been entered into the or command.");
			return -1;
		}
	}
}