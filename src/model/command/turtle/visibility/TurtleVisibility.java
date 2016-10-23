package Model.command.turtle.visibility;

import Model.animal.Animal;
import Model.command.turtle.TurtleCommand;

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