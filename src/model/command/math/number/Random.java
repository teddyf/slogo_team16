package model.command.math.number;

import model.command.math.MathCommand;

public class Random extends MathCommand {

	public Random() {
		super();
	}

	/**
	 * Reports a random non-negative number strictly less than a maximum value
	 * @param max - the maximum value
	 * @return the random number
	 */
	public double run(double max) {
		return Math.random()*max;
	}
}