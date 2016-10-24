package model.command.math.arithmetic;

import model.command.Parameter;

public class Minus extends MathArithmetic {

	public Minus() {
		super();
		numParams = 1;
	}

	/**
	 * Determines the negative of a value
	 * @param params - array of parameters
	 * @return the negative of the value
	 */
	@Override
	public double run(Parameter[] params) {
		double expression = params[0].getValue();
		return sum(0, -expression);
	}
}