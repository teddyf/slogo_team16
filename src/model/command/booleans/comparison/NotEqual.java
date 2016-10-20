package model.command.booleans.comparison;

public class NotEqual extends BooleanComparison {

	public NotEqual() {
		super();
	}

	/**
	 * Determines if a value (1) is not equal to another value (2)
	 * @param expression1 - value 1
	 * @param expression2 - value 2
	 * @return 1 if value 1 is not equal to value 2, 0 otherwise
	 */
	public double run(double expression1, double expression2) {
		return (1 - equal(expression1, expression2));
	}
}