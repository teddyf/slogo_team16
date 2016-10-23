package model.command.math.number;

import model.command.Command;
import model.command.Parameter;

public class Pi extends Command {

	private final double numParams = 0;
	
	public Pi() {
		super();
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