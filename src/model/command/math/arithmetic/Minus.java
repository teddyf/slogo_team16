package model.command.math.arithmetic;

public class Minus extends MathArithmetic {

	public Minus() {
		super();
	}

	/**
	 * Determines the negative of a value
	 * @param expression - the value 
	 * @return the negative of the value
	 */
	public double run(double expression) {
		return sum(0, -expression);
	}
}