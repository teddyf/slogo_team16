package Model.command.math.exponential;

public class Log extends MathExponential {

	public Log() {
		super();
	}

	/**
	 * Determines the value of the natural log of an expression
	 * @param expression - the expression
	 * @return the value
	 */
	public double run(double expression) {
		return log(expression);
	}
}