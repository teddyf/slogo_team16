package Model.command.math.exponential;

import Model.command.math.MathCommand;

public abstract class MathExponential extends MathCommand {
	public MathExponential() {
		super();
	}
	
	public double power(double base, double exponent) {
		return Math.pow(base, exponent);
	}
	
	public double log(double expression) {
		return Math.log(expression);
	}
}