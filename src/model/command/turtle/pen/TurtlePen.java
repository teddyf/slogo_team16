package model.command.turtle.pen;

import model.animal.Animal;
import model.command.Command;

public abstract class TurtlePen extends Command {
	public TurtlePen() {
		super();
	}

	public double penDown(Animal turtle, double pen) {
		turtle.setPen(pen);
		return turtle.getPen();
	}
}