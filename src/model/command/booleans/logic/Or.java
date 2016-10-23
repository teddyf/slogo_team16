package model.command.booleans.logic;

import model.command.Parameter;

public class Or extends BooleanLogic {

	private final double numParams = 2;
	
	public Or() {
		super();
	}

	/**
	 * Determines logical or of two test values
	 * @param params - array of parameters
	 * @return 1 if value 1 or value 2 are non-zero
	 */
	@Override
	public double run(Parameter[] params) {
		double test1 = params[0].getValue();
		double test2 = params[1].getValue();
		return or(test1, test2);
	}
}