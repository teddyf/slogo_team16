/**
 * This is the class for the PENCOLOR command
 * 
 * @author Aninda Manocha
 */

package model.command.display;

import Controller.Data;
import model.command.Command;
import model.command.Parameter;

public class PenColor extends Command {
	private final double paramCount;
	
	public PenColor() {
		super();
		numParams = 1;
		paramCount = 0;
	}
	
	/**
	 * Determines the pen color
	 * @param params - array of parameters
	 * @return the pen color index
	 */
	@Override
	public double run(Parameter[] params) {
		String color = Data.getInstance().getPenColor();
		double index = Data.getInstance().getPenColorIndex(color);
		return index;
	}
}