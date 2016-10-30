package model.command.booleans.comparison;

import Parsing.ExpressionTree;
import model.animal.Animal;
import model.command.Parameter;

public class NotEqual extends BooleanComparison {
	private final double paramCount;
	
	public NotEqual() {
		super();
		numParams = 3;
		paramCount = 2;
	}

	/**
	 * Determines if a value (1) is not equal to another value (2)
	 * @param params - array of parameters
	 * @return 1 if value 1 is not equal to value 2, 0 otherwise
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double expression1 = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		double expression2 = ExpressionTree.getInstance().process(turtle, params[2].getNode());
		return (1 - equal(expression1, expression2));
	}
}