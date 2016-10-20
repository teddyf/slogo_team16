package model.command.turtle.visibility;

import model.animal.Animal;
import model.command.turtle.TurtleCommand;

public abstract class TurtleVisibility extends TurtleCommand {
	private Animal turtle;

	public TurtleVisibility(Animal turtle) {
		super(turtle);
		this.turtle = turtle;
	}

	public double showTurtle(double show) {
		turtle.setShowing(show);
		return turtle.getShowing();
	}
}