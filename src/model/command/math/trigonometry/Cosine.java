package model.command.math.trigonometry;

public class Cosine extends MathTrigonometry {

	public Cosine() {
		super();
	}

	/**
	 * Determines the cosine of a value in degrees
	 * @param degrees - the value in degrees
	 * @return the cosine value
	 */
	public double run(double degrees) {
		return cos(degrees);
	}
}