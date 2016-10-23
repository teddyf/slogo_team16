package Model.command.math.arithmetic;

public class Sum extends MathArithmetic {

	public Sum() {
		super();
	}

	/**
	 * Determines the sum of two values
	 * @param expression1 - value 1
	 * @param expression2 - value 2
	 * @return the sum
	 */
	public double run(double expression1, double expression2) {
		return sum(expression1, expression2);
	}
}