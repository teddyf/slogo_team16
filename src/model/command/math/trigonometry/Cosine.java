package model.command.math.trigonometry;

import model.command.Parameter;

public class Cosine extends MathTrigonometry {

	public Cosine() {
		super();
		numParams = 1;
	}

	/**
	 * Determines the cosine of a value in degrees
	 * @param params - array of parameters
	 * @return the cosine value
	 */
	@Override
	public double run(Parameter[] params) {
		double degrees = params[0].getValue();
		return cos(degrees);
	}
}