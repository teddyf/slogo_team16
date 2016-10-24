package model.command.math.arithmetic;

import model.command.Parameter;

public class Product extends MathArithmetic {

	public Product() {
		super();
		numParams = 2;
	}

	/**
	 * Determines the product of two values
	 * @param params - array of parameters
	 * @return the product
	 */
	public double run(Parameter[] params) {
		double expression1 = params[0].getValue();
		double expression2 = params[1].getValue();
		return product(expression1, expression2);
	}
}