package Model.command.math.number;

import Model.command.math.MathCommand;

public class Pi extends MathCommand {

	public Pi() {
		super();
	}

	/**
	 * Reports the number pi
	 * @return pi
	 */
	public double run() {
		return Math.PI;
	}
}