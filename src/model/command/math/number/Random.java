package model.command.math.number;

import Parsing.ExpressionTree;
import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;

public class Random extends Command {
	private final double paramCount;
	
	public Random() {
		super();
		numParams = 2;
		paramCount = 1;
	}

	/**
	 * Reports a random non-negative number strictly less than a maximum value
	 * @param params - array of parameters
	 * @return the random number
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double max = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		return Math.random()*max;
	}
}