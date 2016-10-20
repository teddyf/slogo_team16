package model.command.math.trigonometry;

public class ArcTangent extends MathTrigonometry {

	public ArcTangent() {
		super();
	}

	/**
	 * Determines the arc tangent of a value in degrees
	 * @param degrees - the value in degrees
	 * @return the arc tangent value
	 */
	public double run(double degrees) {
		return atan(degrees);
	}
}