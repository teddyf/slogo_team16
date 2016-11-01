package model.command.turtle.movement;

import Controller.Data;
import model.animal.Animal;
import model.command.Parameter;

public class ClearScreen extends TurtleMovement{
	private final double paramCount;
	
	public ClearScreen() {
		super();
		numParams = 1;
		paramCount = 0;
	}

	/**
	 * Erases the animal's trails and places it at the center of the screen
	 * @param params - array of parameters
	 * @return the distance the turtle moved
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		Data.getInstance().setClearScreen(true);
		System.out.println("Singleton clear screen bool: "+Data.getInstance().getClearScreen());
		return moveTo(turtle, 0,0);
	}
}