package Model.command.booleans.comparison;

public class Less extends BooleanComparison {

	public Less() {
		super();
	}

	/**
	 * Determines if a value (1) is less than another value (2)
	 * @param expression1 - value 1
	 * @param expression2 - value 2
	 * @return 1 if value 1 is less than value 2, 0 otherwise
	 */
	public double run(double expression1, double expression2) {
		return compare(expression1, expression2);
	}
}