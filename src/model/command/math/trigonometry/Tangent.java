package model.command.math.trigonometry;

import model.command.Parameter;

public class Tangent extends MathTrigonometry {

	private final double numParams = 1;
	public Tangent () {
		super();
	}

	/**
	 * Determines the tangent of a value in degrees
	 * @param params - array of parameters 
	 * @return the tangent value
	 */
	@Override
	public double run(Parameter[] params) {
		double degrees = params[0].getValue();
		return sin(degrees)/cos(degrees);
	}
}