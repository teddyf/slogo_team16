/**
 * This is the class for the NOT command
 * 
 * @author Aninda Manocha
 */

package model.command.booleans.logic;

import Parsing.expression.ConstantExpression;
import Parsing.expression.ExpressionTree;
import Parsing.expression.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;

public class Not extends BooleanLogic {
	private final double paramCount;
	
	public Not() {
		super();
		numParams = 2;
		paramCount = 1;
	}

	/**
	 * Determines logical opposite of a value
	 * @param params - array of parameters
	 * @return 1 if value is 0 and 0 if value is 1
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double test = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		return not(test);
	}
}