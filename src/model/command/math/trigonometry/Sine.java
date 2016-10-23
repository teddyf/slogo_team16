package model.command.math.trigonometry;

import model.command.Parameter;

public class Sine extends MathTrigonometry {

	private final double numParams = 1;
	
	public Sine() {
		super();
	}

	/**
	 * Determines the sine of a value in degrees
	 * @param params - array of parameters
	 * @return the sine value
	 */
	@Override
	public double run(Parameter[] params) {
		double degrees = params[0].getValue();
		return sin(degrees);
	}
}