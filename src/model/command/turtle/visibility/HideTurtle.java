package Model.command.turtle.visibility;

import Model.animal.Animal;

public class HideTurtle extends TurtleVisibility {

	public HideTurtle(Animal turtle) {
		super(turtle);
	}

	/**
	 * Makes the animal invisible
	 * 
	 * @return 0
	 */
	public double run() {
		return showTurtle(0);
	}
}