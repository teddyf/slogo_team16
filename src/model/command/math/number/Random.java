package model.command.math.number;

import model.command.Command;
import model.command.Parameter;

public class Random extends Command {

	public Random() {
		super();
		numParams = 1;
	}

	/**
	 * Reports a random non-negative number strictly less than a maximum value
	 * @param params - array of parameters
	 * @return the random number
	 */
	@Override
	public double run(Parameter[] params) {
		double max = params[0].getValue();
		return Math.random()*max;
	}
}