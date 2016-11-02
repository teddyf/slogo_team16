/**
 * This is the MathArithmetic class, which contains methods for arithmetic calculations
 * 
 * @author Aninda Manocha
 */

package model.command.math.arithmetic;

import model.command.Command;

public abstract class MathArithmetic extends Command {
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