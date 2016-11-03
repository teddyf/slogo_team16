/**
 * This is the class for the QUOTIENT command
 * 
 * @author Aninda Manocha
 */

package model.command.math.arithmetic;

import Parsing.expression.ConstantExpression;
import Parsing.expression.ExpressionTree;
import Parsing.expression.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;

public class Quotient extends MathArithmetic {
	private final double paramCount;
	
	public Quotient() {
		super();
		numParams = 3;
		paramCount = 2;
	}

	/**
	 * Determines the quotient of two values
	 * @param params - array of parameters
	 * @return the quotient
	 */
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double expression1 = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		double expression2 = ExpressionTree.getInstance().process(turtle, params[2].getNode());
		return product(expression1, 1.0/expression2);
	}
}