package model.command.booleans.comparison;

import model.command.Parameter;

public class Greater extends BooleanComparison {

	public Greater() {
		super();
		numParams = 2;
	}

	/**
	 * Determines if a value (1) is greater than another value (2)
	 * @param params - array of parameters
	 * @return 1 if value 1 is greater than value 2, 0 otherwise
	 */
	@Override
	public double run(Parameter[] params) {
		double expression1 = params[0].getValue();
		double expression2 = params[1].getValue();
		return compare(-expression1, -expression2);
	}
}