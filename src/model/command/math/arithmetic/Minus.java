package model.command.math.arithmetic;

import model.command.Parameter;

public class Minus extends MathArithmetic {

	private final double numParams = 1;
	
	public Minus() {
		super();
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