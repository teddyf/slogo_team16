package model.command.math.arithmetic;

import Parsing.ExpressionTree;
import model.animal.Animal;
import model.command.Parameter;

public class Sum extends MathArithmetic {
	private final double paramCount;
	
	public Sum() {
		super();
		numParams = 3;
		paramCount = 2;
	}

	/**
	 * Determines the sum of two values
	 * @param params - array of parameters
	 * @return the sum
	 */
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double expression1 = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		double expression2 = ExpressionTree.getInstance().process(turtle, params[2].getNode());
		return sum(expression1, expression2);
	}
}