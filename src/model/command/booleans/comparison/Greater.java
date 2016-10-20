package model.command.booleans.comparison;

public class Greater extends BooleanComparison {

	public Greater() {
		super();
	}

	/**
	 * Determines if a value (1) is greater than another value (2)
	 * @param expression1 - value 1
	 * @param expression2 - value 2
	 * @return 1 if value 1 is greater than value 2, 0 otherwise
	 */
	public double run(double expression1, double expression2) {
		return compare(-expression1, -expression2);
	}
}