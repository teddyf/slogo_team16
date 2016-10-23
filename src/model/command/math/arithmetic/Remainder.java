package Model.command.math.arithmetic;

public class Remainder extends MathArithmetic {

	public Remainder() {
		super();
	}

	/**
	 * Determines the remainder of two values
	 * @param expression1 - value 1
	 * @param expression2 - value 2
	 * @return the remainder
	 */
	public double run(double expression1, double expression2) {
		return remainder(expression1, expression2);
	}
}