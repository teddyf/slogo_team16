package Model.command.turtle.movement;

import Model.animal.Animal;

public class Home extends TurtleMovement {

	public Home(Animal turtle) {
		super(turtle);
	}

	/**
	 * Moves the animal to the center of the screen
	 * 
	 * @return the distance the turtle moved
	 */
	public double run() {
		return moveTo(0,0);
	}
}