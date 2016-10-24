package model.command.math.trigonometry;

import model.command.Parameter;

public class Tangent extends MathTrigonometry {

	public Tangent () {
		super();
		numParams = 1;
	}

	/**
	 * Determines the tangent of a value in degrees
	 * @param params - array of parameters 
	 * @return the tangent value
	 */
	@Override
	public double run(Parameter[] params) {
		double degrees = params[0].getValue();
		if (degrees == 90) {
			return Double.POSITIVE_INFINITY;
		}
		if (degrees == 270) {
			return Double.NEGATIVE_INFINITY;
		}
		return sin(degrees)/cos(degrees);
	}
}