/**
 * This is the class for the GREATER command
 * 
 * @author Aninda Manocha
 */

package model.command.booleans.comparison;

import Parsing.expression.ConstantExpression;
import Parsing.expression.ExpressionTree;
import Parsing.expression.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;

public class Greater extends BooleanComparison {
	private final double paramCount;
	
	public Greater() {
		super();
		numParams = 3;
		paramCount = 2;
	}

	/**
	 * Determines if a value (1) is greater than another value (2)
	 * @param params - array of parameters
	 * @return 1 if value 1 is greater than value 2, 0 otherwise
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression)) 
				&& ((params[2].getNode().expression instanceof ConstantExpression) || (params[2].getNode().expression instanceof VariableExpression))) {
			double expression1 = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			double expression2 = ExpressionTree.getInstance().process(turtle, params[2].getNode());
			return compare(-expression1, -expression2);
		} else {
			super.commandInputError(this.getName());
			return -1;
		}
	}
}