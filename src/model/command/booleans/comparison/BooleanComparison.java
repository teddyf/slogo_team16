package model.command.booleans.comparison;

import model.command.booleans.BooleanCommand;

public abstract class BooleanComparison extends BooleanCommand{
	public BooleanComparison() {
		super();
	}
	
	public double compare(double expression1, double expression2) {
		if (expression1 < expression2) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public double equal(double expression1, double expression2) {
		if (expression1 == expression2) {
			return 1;
		} else {
			return 0;
		}
	}
}