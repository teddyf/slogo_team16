package model.command.math.exponential;

import model.command.Parameter;

public class Power extends MathExponential {

	private final double numParams = 2;
	
	public Power() {
		super();
	}

	/**
	 * Determines the value of a base raised to the power of an exponent
	 * @param params - array of parameters
	 * @return - the value
	 */
	@Override
	public double run(Parameter[] params) {
		double base = params[0].getValue();
		double exponent = params[1].getValue();
		return power(base, exponent);
	}
}