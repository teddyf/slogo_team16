package model.command.math.arithmetic;

import model.command.Parameter;

public class Difference extends MathArithmetic {

	public Difference() {
		super();
		numParams = 2;
	}

	/**
	 * Determines the difference of two values
	 * @param params - array of parameters
	 * @return the difference
	 */
	@Override
	public double run(Parameter[] params) {
		double expression1 = params[0].getValue();
		double expression2 = params[1].getValue();
		return sum(expression1, -expression2);
	}
}