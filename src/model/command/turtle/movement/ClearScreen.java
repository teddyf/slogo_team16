package model.command.turtle.movement;

import Controller.Data;
import model.animal.Animal;
import model.command.Parameter;

/*
 * Aninda Manocha
 * This entire file is part of my masterpiece.
 */

/**
 * This is the class for the CLEARSCREEN command
 * 
 * @author Aninda Manocha
 */

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
		return moveTo(turtle, 0,0);
	}
}