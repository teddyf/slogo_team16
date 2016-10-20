package model.command.math.trigonometry;

public class Tangent extends MathTrigonometry {

	public Tangent () {
		super();
	}

	/**
	 * Determines the tangent of a value in degrees
	 * @param degrees - the value in degrees
	 * @return the tangent value
	 */
	public double run(double degrees) {
		return sin(degrees)/cos(degrees);
	}
}