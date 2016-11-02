/**
 * This is the class for the HEADING command
 * 
 * @author Aninda Manocha
 */

package model.command.turtle.query;

import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;

public class Heading extends Command {
	private final double paramCount;
	
	public Heading() {
		super();
		numParams = 1;
		paramCount = 0;
	}
	
	/**
	 * Gets the turtle's heading in degrees
	 * @param params - array of parameters
	 * @return the heading
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		return turtle.getHeading();
		
	}
}