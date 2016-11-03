/**
 * This is the class for the OR command
 * 
 * @author Aninda Manocha
 */

package model.command.booleans.logic;

import Parsing.expression.ConstantExpression;
import Parsing.expression.ExpressionTree;
import Parsing.expression.VariableExpression;
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
		double test1 = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		double test2 = ExpressionTree.getInstance().process(turtle, params[2].getNode());
		return or(test1, test2);
	}
}