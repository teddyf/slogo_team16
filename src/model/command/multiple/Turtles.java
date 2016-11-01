package model.command.multiple;

import Controller.Data;
import model.command.Command;
import model.command.Parameter;

public class Turtles extends Command {
	private final double paramCount;
	
	public Turtles() {
		super();
		numParams = 1;
		paramCount = 0;
	}
	
	/**
	 * Determines the number of turtles created so far
	 * @param params - array of parameters
	 * @return the number of turtles
	 */
	@Override
	public double run(Parameter[] params) {
		return Data.getInstance().getNumTurtles();
	}
}