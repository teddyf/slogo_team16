/**
 * This is the class for the YCOR command
 * 
 * @author Aninda Manocha
 */

package model.command.turtle.query;

import View.Workspace;
import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;

public class YCor extends Command {
	private final double paramCount;
	
	public YCor() {
		super();
		numParams = 1;
		paramCount = 0;
	}
	
	/**
	 * Gets the turtle's y coordinate from the center of the screen
	 * @param params - array of parameters
	 * @return the y coordinate
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		return Workspace.LEFT_PANE_HEIGHT/2 - turtle.getY();
		
	}
}