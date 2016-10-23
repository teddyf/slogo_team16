package Model.command.math.arithmetic;

public class Difference extends MathArithmetic {

	public Difference() {
		super();
	}

	/**
	 * Determines the difference of two values
	 * @param expression1 - value 1
	 * @param expression2 - value 2
	 * @return the difference
	 */
	public double run(double expression1, double expression2) {
		return sum(expression1, -expression2);
	}
}