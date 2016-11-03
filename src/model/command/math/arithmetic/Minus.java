package model.command.math.arithmetic;

import Parsing.ConstantExpression;
import Parsing.ExpressionTree;
import Parsing.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;

public class Minus extends MathArithmetic {
	private final double paramCount;
	
	public Minus() {
		super();
		numParams = 2;
		paramCount = 1;
	}

	/**
	 * Determines the negative of a value
	 * @param params - array of parameters
	 * @return the negative of the value
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression))) {
			double expression = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			return sum(0, -expression);
		} else {
			super.commandInputError(this.getName());
			return -1;
		}
	}
}