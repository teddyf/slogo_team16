package model.command.turtle.movement;

import View.Workspace;
import model.animal.Animal;
import model.command.turtle.TurtleCommand;

/*
 * Aninda Manocha
 * This entire file is part of my masterpiece.
 */

/**
 * This is the TurtleMovement class containing methods for moving the turtle to certain positions
 * 
 * @author Aninda Manocha
 */

public abstract class TurtleMovement extends TurtleCommand {
	public TurtleMovement() {
		super();
	}

	/**
	 * Moves the turtle a given number of pixels
	 * @param turtle - the turtle that is to be moved
	 * @param pixels - number of pixels 
	 * @return number of pixels moved
	 */
	public double move(Animal turtle, double pixels) {
		double angle = 90 - turtle.getHeading();
		turtle.setX(turtle.getX() + Math.cos(angle*Math.PI/180) * pixels);
		turtle.setY(turtle.getY() - Math.sin(angle*Math.PI/180) * pixels);
		return pixels;
	}

	/**
	 * Moves the turtle to a specified position
	 * @param turtle - the turtle that is to be moved
	 * @param x - x coordinate of position
	 * @param y - y coordinate of position
	 * @return the distance the turtle moved
	 */
	public double moveTo(Animal turtle, double x, double y) {
		double turtleX = turtle.getX() - Workspace.LEFT_PANE_WIDTH/2;
		double turtleY = Workspace.LEFT_PANE_HEIGHT/2 - turtle.getY();
		double distance = Math.sqrt(Math.pow(turtleX - x, 2) + Math.pow(turtleY - y, 2));
		turtle.setX(x + Workspace.LEFT_PANE_WIDTH / 2);
		turtle.setY(Workspace.LEFT_PANE_HEIGHT / 2 - y);
		return distance;
	}
}