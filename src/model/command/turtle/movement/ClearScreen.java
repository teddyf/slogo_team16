package model.command.turtle.movement;

import model.animal.Animal;

public class ClearScreen extends TurtleMovement {

	public ClearScreen(Animal turtle) {
		super(turtle);
	}

	/**
	 * Erases the animal's trails and places it at the center of the screen
	 * 
	 * @return the distance the turtle moved
	 */
	public double run() {
		return moveTo(0,0);
	}
}