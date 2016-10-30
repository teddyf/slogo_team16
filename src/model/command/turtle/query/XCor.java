package model.command.turtle.query;

import model.command.Command;
import model.command.Parameter;

public class XCor extends Command {
	private final double paramCount;
	
	public XCor() {
		super();
		numParams = 1;
		paramCount = 0;
	}
	
	/**
	 * Gets the turtle's x coordinate from the center of the screen
	 * @param params - array of parameters
	 * @return the x coordinate
	 */
	@Override
	public double run(Parameter[] params) {
		return Math.PI;
	}
}