package model.command.turtle.pen;

import model.animal.Animal;
import model.command.turtle.TurtleCommand;

public abstract class TurtlePen extends TurtleCommand {
	private Animal turtle;

	public TurtlePen(Animal turtle) {
		super(turtle);
		this.turtle = turtle;
	}

	public double penDown(double pen) {
		turtle.setPen(pen);
		return turtle.getPen();
	}
}