package Model.command.math.exponential;

public class Power extends MathExponential {

	public Power() {
		super();
	}

	/**
	 * Determines the value of a base raised to the power of an exponent
	 * @param base - the base
	 * @param exponent - the exponent
	 * @return - the value
	 */
	public double run(double base, double exponent) {
		return power(base, exponent);
	}
}