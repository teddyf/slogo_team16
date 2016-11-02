/**
 * This is the BooleanComparison class that contains methods for comparing expressions.
 * 
 * @author Aninda Manocha
 */
package model.command.booleans.comparison;

import model.command.Command;

public abstract class BooleanComparison extends Command{
	public BooleanComparison() {
		super();
	}
	
	/**
	 * Compares two expressions in value
	 * @param expression1 - first expression
	 * @param expression2 - second expression
	 * @return 1 if expression1 < expression2, 0 otherwise
	 */
	public double compare(double expression1, double expression2) {
		if (expression1 < expression2) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * Determines if two expressions are equal
	 * @param expression1 - first expression
	 * @param expression2 - second expression
	 * @return 1 if the expressions are equal, 0 otherwise
	 */
	public double equal(double expression1, double expression2) {
		if (expression1 == expression2) {
			return 1;
		} else {
			return 0;
		}
	}
}