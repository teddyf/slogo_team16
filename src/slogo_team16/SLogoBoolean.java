package slogo_team16;

public class SLogoBoolean {
	public SLogoBoolean() {
		
	}
	
	public int less(double expression1, double expression2) {
		if (expression1 < expression2) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int greater(double expression1, double expression2) {
		if (expression1 > expression2) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int equal(double expression1, double expression2) {
		if (expression1 == expression2) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int notEqual(double expression1, double expression2) {
		if (expression1 != expression2) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int and(int test1, int test2) {
		if (test1 != 0 && test2 != 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int or(int test1, int test2) {
		if (test1 != 0 || test2 != 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int not(int test) {
		if (test == 0) {
			return 1;
		} else {
			return 0;
		}
	}
}