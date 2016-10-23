package Model.command.math.arithmetic;

public class Quotient extends MathArithmetic {

	public Quotient() {
		super();
	}

	/**
	 * Determines the quotient of two values
	 * @param expression1 - value 1
	 * @param expression2 - value 2
	 * @return the quotient
	 */
	public double run(double expression1, double expression2) {
		return product(expression1, 1/expression2);
	}
}