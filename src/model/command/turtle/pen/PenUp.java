package model.command.turtle.pen;

import model.animal.Animal;

public class PenUp extends TurtlePen {

	public PenUp(Animal turtle) {
		super(turtle);
	}

	/**
	 * Puts pen up so that the animal doesn't leave a trail when it moves
	 * 
	 * @return 0
	 */
	public double run() {
		return penDown(0);
	}
}