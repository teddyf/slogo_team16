package Model.command.booleans.comparison;

public class Equal extends BooleanComparison {

	public Equal() {
		super();
	}

	/**
	 * Determines if a value (1) is equal to another value (2)
	 * @param expression1 - value 1
	 * @param expression2 - value 2
	 * @return 1 if value 1 is equal to value 2, 0 otherwise
	 */
	public double run(double expression1, double expression2) {
		return equal(expression1, expression2);
	}
}