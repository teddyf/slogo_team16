package model.command.math.exponential;

import model.command.Parameter;

public class Log extends MathExponential {

	public Log() {
		super();
		numParams = 1;
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