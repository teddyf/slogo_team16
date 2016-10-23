package Model.command.booleans.logic;

public class Or extends BooleanLogic {

	public Or() {
		super();
	}

	/**
	 * Determines logical or of two test values
	 * @param test1 - value 1
	 * @param test2 - value 2
	 * @return 1 if value 1 or value 2 are non-zero
	 */
	public double run(double test1, double test2) {
		return or(test1, test2);
	}
}