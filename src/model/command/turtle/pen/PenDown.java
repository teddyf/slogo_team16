package Model.command.turtle.pen;

import Model.animal.Animal;

public class PenDown extends TurtlePen {

	public PenDown(Animal turtle) {
		super(turtle);
	}

	/**
	 * Puts pen down so that the animal leaves a trail when it moves
	 * 
	 * @return 1
	 */
	public double run() {
		return penDown(1);
	}
}