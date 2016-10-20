package model.command.math.trigonometry;

public class Sine extends MathTrigonometry {

	public Sine() {
		super();
	}

	/**
	 * Determines the sine of a value in degrees
	 * @param degrees - the value in degrees
	 * @return the sine value
	 */
	public double run(double degrees) {
		return sin(degrees);
	}
}