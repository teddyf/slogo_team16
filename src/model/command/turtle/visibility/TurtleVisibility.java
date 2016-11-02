/**
 * This is the TurtleVisibility class that controls the turtle visibility
 * 
 * @author Aninda Manocha
 */

package model.command.turtle.visibility;

import model.animal.Animal;
import model.command.turtle.TurtleCommand;

public abstract class TurtleVisibility extends TurtleCommand {
	public TurtleVisibility() {
		super();
	}

	public double showTurtle(Animal turtle, double show) {
		turtle.setShowing(show);
		return turtle.getShowing();
	}
}