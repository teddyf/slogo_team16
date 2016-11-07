/**
 * This is the class for the PENDOWN command
 * 
 * @author Aninda Manocha
 */

package model.command.turtle.query;

import model.animal.Animal;
import model.command.Parameter;
import model.command.turtle.pen.TurtlePen;

public class Pendown extends TurtlePen {
	private final double paramCount;
	
	public Pendown() {
		super();
		numParams = 1;
		paramCount = 0;
	}
	
	/**
	 * Determines if the turtle's pen is down
	 * @param params - array of parameters
	 * @return 1 if pendown, 0 otherwise
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		return penDown(turtle, 1);
		
	}
}