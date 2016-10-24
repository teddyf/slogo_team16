package model.command.math.number;

import model.command.Command;
import model.command.Parameter;

public class Pi extends Command {

	public Pi() {
		super();
		numParams = 0;
	}

	/**
	 * Reports the number pi
	 * @return pi
	 */
	@Override
	public double run(Parameter[] params) {
		return Math.PI;
	}
}