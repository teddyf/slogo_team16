/**
 * This is the BooleanLogic class that contains methods for logical comparisons
 * 
 * @author Aninda Manocha
 */

package model.command.booleans.logic;

import model.command.Command;

public abstract class BooleanLogic extends Command{
	public BooleanLogic() {
		super();
	}
	
	public double and(double test1, double test2) {
		if (test1 != 0 && test2 != 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public double or(double test1, double test2) {
		if (test1 != 0 || test2 != 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public double not(double test) {
		if (test == 0) {
			return 1;
		} else {
			return 0;
		}
	}
}