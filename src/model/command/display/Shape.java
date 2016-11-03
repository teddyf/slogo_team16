/**
 * This is the class for the SHAPE command
 * 
 * @author Aninda Manocha
 */

package model.command.display;

import Controller.Data;
import model.command.Command;
import model.command.Parameter;

public class Shape extends Command {
	private final double paramCount;
	
	public Shape() {
		super();
		numParams = 1;
		paramCount = 0;
	}
	
	/**
	 * Determines the turtle shape
	 * @param params - array of parameters
	 * @return the pen color index
	 */
	@Override
	public double run(Parameter[] params) {
		String shape = Data.getInstance().getShape();
		double index = Data.getInstance().getShapeIndex(shape);
		return index;
	}
}