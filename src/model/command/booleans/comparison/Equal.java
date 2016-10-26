package model.command.booleans.comparison;

import model.command.Parameter;

public class Equal extends BooleanComparison {
	private final double paramCount;
	
	public Equal() {
		super();
		numParams = 2;
		paramCount = 2;
	}

	/**
	 * Determines if a value (1) is equal to another value (2)
	 * @param params - array of parameters
	 * @return 1 if value 1 is equal to value 2, 0 otherwise
	 */
	@Override
	public double run(Parameter[] params) {
		double expression1 = params[0].getValue();
		double expression2 = params[1].getValue();
		return equal(expression1, expression2);
	}
}