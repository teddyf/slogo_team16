package model.command.math.arithmetic;

public class Product extends MathArithmetic {

	public Product() {
		super();
	}

	/**
	 * Determines the product of two values
	 * @param expression1 - value 1
	 * @param expression2 - value 2
	 * @return the product
	 */
	public double run(double expression1, double expression2) {
		return product(expression1, expression2);
	}
}