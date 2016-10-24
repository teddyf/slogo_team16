package model.command.math.trigonometry;

import model.command.Parameter;

public class ArcTangent extends MathTrigonometry {

	public ArcTangent() {
		super();
		numParams = 1;
	}

	/**
	 * Determines the arc tangent of a value in degrees
	 * @param params - array of parameters
	 * @return the arc tangent value
	 */
	@Override
	public double run(Parameter[] params) {
		double degrees = params[0].getValue();
		return atan(degrees);
	}
}