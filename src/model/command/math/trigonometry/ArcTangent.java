package model.command.math.trigonometry;

import model.command.Parameter;

public class ArcTangent extends MathTrigonometry {

	private final double numParams = 1;
	
	public ArcTangent() {
		super();
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