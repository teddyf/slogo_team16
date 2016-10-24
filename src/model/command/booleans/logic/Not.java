package model.command.booleans.logic;

import model.command.Parameter;

public class Not extends BooleanLogic {
	private final double paramCount;
	
	public Not() {
		super();
		numParams = 1;
		paramCount = 1;
	}

	/**
	 * Determines logical opposite of a value
	 * @param params - array of parameters
	 * @return 1 if value is 0 and 0 if value is 1
	 */
	@Override
	public double run(Parameter[] params) {
		double test = params[0].getValue();
		return not(test);
	}
}