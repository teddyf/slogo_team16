/**
 * This is the TurtleRotation class, which contains methods for rotating the turtle
 * 
 * @author Aninda Manocha
 */

package model.command.turtle.rotation;

import View.Workspace;
import model.animal.Animal;
import model.command.turtle.TurtleCommand;

public abstract class TurtleRotation extends TurtleCommand {
	public TurtleRotation() {
		super();
	}

	/**
	 * Turns the turtle a given number of degrees
	 * @param turtle - the turtle to be rotated
	 * @param degrees - the number of degrees
	 * @param left - whether to rotate left
	 * @return the number of degrees turned
	 */
	public double turn(Animal turtle, double degrees, double left) {
		turtle.setHeading(turtle.getHeading() + degrees);
		turtle.setHeading(turtle.getHeading() % 360);
		if (left == 1) {
			if (turtle.getHeading() < 0) {
				turtle.setHeading(360 + turtle.getHeading());
			}
		}
		return degrees;
	}

	/**
	 * Turns the turtle to a given heading
	 * @param turtle - the turtle to be rotated
	 * @param heading - the given heading
	 * @return - the number of degrees turned
	 */
	public double turnTo(Animal turtle, double heading) {
		heading = heading % 360;
		double diff = Math.abs(turtle.getHeading() - heading);
		turtle.setHeading(heading);
		if (diff <= 180) {
			return diff;
		} else {
			return 360 - diff;
		}
	}

	/**
	 * Turns the turtle to a given point
	 * @param turtle - the turtle to be rotated
	 * @param x - the x coordinate of the point
	 * @param y - the y coordinate of the point
	 * @return the number of degrees turned
	 */
	public double turnTo(Animal turtle, double x, double y) {
		double x_diff = x - (turtle.getX() - Workspace.LEFT_PANE_WIDTH/2);
		double y_diff = y - (Workspace.LEFT_PANE_HEIGHT/2 - turtle.getY());
		System.out.println("x diff " + x_diff);
		System.out.println("y diff " + y_diff);
		double heading = 90 - Math.atan2(y_diff, x_diff)*180/Math.PI;
		return turnTo(turtle, heading);
	}
}