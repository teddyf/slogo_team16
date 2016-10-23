package Model.command.turtle.pen;

import Model.animal.Animal;
import Model.command.turtle.TurtleCommand;

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