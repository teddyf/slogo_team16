package Model.command.booleans.logic;

public class Not extends BooleanLogic {

	public Not() {
		super();
	}

	/**
	 * Determines logical opposite of a value
	 * @param test - value
	 * @return 1 if value is 0 and 0 if value is 1
	 */
	public double run(double test) {
		return not(test);
	}
}