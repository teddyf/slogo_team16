package model.command.math.exponential;

import model.command.Command;

public abstract class MathExponential extends Command {
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