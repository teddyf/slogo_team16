package model.command.turtle.visibility;

import model.animal.Animal;
import model.command.Command;

public abstract class TurtleVisibility extends Command {
	public TurtleVisibility() {
		super();
	}

	public double showTurtle(Animal turtle, double show) {
		turtle.setShowing(show);
		return turtle.getShowing();
	}
}