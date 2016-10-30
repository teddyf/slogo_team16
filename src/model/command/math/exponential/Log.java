package model.command.math.exponential;

import Parsing.ExpressionTree;
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
		double expression = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		return log(expression);
	}
}