/**
 * This is the class for the PRODUCT command
 * 
 * @author Aninda Manocha
 */

package model.command.math.arithmetic;

import Parsing.expression.ConstantExpression;
import Parsing.expression.ExpressionTree;
import Parsing.expression.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;

public class Product extends MathArithmetic {
	private final double paramCount;
	
	public Product() {
		super();
		numParams = 3;
		paramCount = 2;
	}

	/**
	 * Determines the product of two values
	 * @param params - array of parameters
	 * @return the product
	 */
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression)) 
				&& ((params[2].getNode().expression instanceof ConstantExpression) || (params[2].getNode().expression instanceof VariableExpression))) {
			double expression1 = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			double expression2 = ExpressionTree.getInstance().process(turtle, params[2].getNode());
			return product(expression1, expression2);
		} else {
			super.commandInputError(this.getName());
			return -1;
		}
	}
}