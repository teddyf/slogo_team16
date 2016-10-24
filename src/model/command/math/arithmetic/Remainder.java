package model.command.math.arithmetic;

import model.command.Parameter;

public class Remainder extends MathArithmetic {
	private final double paramCount;
	
	public Remainder() {
		super();
		numParams = 2;
		paramCount = 2;
	}

	/**
	 * Determines the remainder of two values
	 * @param params - array of parameters
	 * @return the remainder
	 */
	public double run(Parameter[] params) {
		double expression1 = params[0].getValue();
		double expression2 = params[1].getValue();
		return remainder(expression1, expression2);
	}
}