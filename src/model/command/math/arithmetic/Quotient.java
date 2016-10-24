package model.command.math.arithmetic;

import model.command.Parameter;

public class Quotient extends MathArithmetic {

	public Quotient() {
		super();
		numParams = 2;
	}

	/**
	 * Determines the quotient of two values
	 * @param params - array of parameters
	 * @return the quotient
	 */
	public double run(Parameter[] params) {
		double expression1 = params[0].getValue();
		double expression2 = params[0].getValue();
		return product(expression1, 1/expression2);
	}
}