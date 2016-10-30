package model.command.math.exponential;

import Parsing.ExpressionTree;
import model.animal.Animal;
import model.command.Parameter;

public class Power extends MathExponential {
	private final double paramCount;
	
	public Power() {
		super();
		numParams = 3;
		paramCount = 2;
	}

	/**
	 * Determines the value of a base raised to the power of an exponent
	 * @param params - array of parameters
	 * @return - the value
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double base = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		double exponent = ExpressionTree.getInstance().process(turtle, params[2].getNode());
		return power(base, exponent);
	}
}