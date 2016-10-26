package model.command.booleans.logic;

import model.command.Parameter;

public class And extends BooleanLogic {
	private final double paramCount;
	
	public And() {
		super();
		numParams = 2;
		paramCount = 2;
	}

	/**
	 * Determines logical and of two test values
	 * @param params - array of parameters
	 * @return 1 if value 1 and value 2 are both non-zero
	 */
	@Override
	public double run(Parameter[] params) {
		double test1 = params[0].getValue();
		double test2 = params[1].getValue();
		return and(test1, test2);
	}
}