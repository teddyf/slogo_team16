/**
 * This is the class for the ID command
 * 
 * @author Aninda Manocha
 */

package model.command.multiple;

import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;

public class ID extends Command {
	private final double paramCount;
	
	public ID() {
		super();
		numParams = 1;
		paramCount = 0;
	}
	
	/**
	 * Determines the current active turtle's ID number
	 * @param params - array of parameters
	 * @return the ID number
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		return turtle.getId();
	}
}