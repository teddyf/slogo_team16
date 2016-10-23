package model.command.math.exponential;

import model.command.Parameter;

public class Log extends MathExponential {

	private final double numParams = 1;
	
	public Log() {
		super();
	}

	/**
	 * Determines the value of the natural log of an expression
	 * @param params - array of parameters
	 * @return the value
	 */
	@Override
	public double run(Parameter[] params) {
		double expression = params[0].getValue();
		return log(expression);
	}
}