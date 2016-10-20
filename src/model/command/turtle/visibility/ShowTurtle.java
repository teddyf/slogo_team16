package model.command.turtle.visibility;

import model.animal.Animal;

public class ShowTurtle extends TurtleVisibility {

	public ShowTurtle(Animal turtle) {
		super(turtle);
	}

	/**
	 * Makes the animal visible
	 * 
	 * @return 1
	 */
	public double run() {
		return showTurtle(1);
	}
}