package model.command.turtle.pen;

import model.animal.Animal;
import model.command.turtle.TurtleCommand;

public abstract class TurtlePen extends TurtleCommand {
	public TurtlePen() {
		super();
	}

	public double penDown(Animal turtle, double pen) {
		turtle.setPen(pen);
		return turtle.getPen();
	}
}