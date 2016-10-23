package Model.command.booleans.logic;

public class And extends BooleanLogic {

	public And() {
		super();
	}

	/**
	 * Determines logical and of two test values
	 * @param test1 - value 1
	 * @param test2 - value 2
	 * @return 1 if value 1 and value 2 are both non-zero
	 */
	public double run(double test1, double test2) {
		return and(test1, test2);
	}
}