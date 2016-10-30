package model.command.booleans.logic;

import Parsing.ExpressionTree;
import model.animal.Animal;
import model.command.Parameter;

public class And extends BooleanLogic {
	private final double paramCount;
	
	public And() {
		super();
		numParams = 3;
		paramCount = 2;
	}

	/**
	 * Determines logical and of two test values
	 * @param params - array of parameters
	 * @return 1 if value 1 and value 2 are both non-zero
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double test1 = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		double test2 = ExpressionTree.getInstance().process(turtle, params[2].getNode());
		return and(test1, test2);
	}
}