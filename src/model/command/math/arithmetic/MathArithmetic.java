package model.command.math.arithmetic;

import model.command.math.MathCommand;

public abstract class MathArithmetic extends MathCommand {
	public MathArithmetic() {
		super();
	}
	
	public double sum(double expression1, double expression2) {
		return expression1 + expression2;
	}
	
	public double product(double expression1, double expression2) {
		return expression1*expression2;
	}
	
	public double remainder(double expression1, double expression2) {
		return expression1 % expression2;
	}
}