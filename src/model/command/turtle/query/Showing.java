package model.command.turtle.query;

import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;

public class Showing extends Command {
	private final double paramCount;
	
	public Showing() {
		super();
		numParams = 1;
		paramCount = 0;
	}
	
	/**
	 * Determines if the turtle is visible
	 * @param params - array of parameters
	 * @return 1 if visible, 0 otherwise
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		return turtle.getShowing();
		
	}
}