/**
 * This is the class for the PI command
 * 
 * @author Aninda Manocha
 */

package model.command.math.number;

import model.command.Command;
import model.command.Parameter;

public class Pi extends Command {
	private final double paramCount;
	
	public Pi() {
		super();
		numParams = 1;
		paramCount = 0;
	}

	/**
	 * Reports the number pi
	 * @param params - array of parameters
	 * @return pi
	 */
	@Override
	public double run(Parameter[] params) {
		return Math.PI;
	}
}