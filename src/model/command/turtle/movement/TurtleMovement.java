package Model.command.turtle.movement;

import View.Workspace;
import Model.animal.Animal;
import Model.command.turtle.TurtleCommand;

public abstract class TurtleMovement extends TurtleCommand {
	private Animal turtle;

	public TurtleMovement(Animal turtle) {
		super(turtle);
		this.turtle = turtle;
	}

	public double move(double pixels) {
		double angle = 90 - turtle.getHeading();
		turtle.setX(turtle.getX() + Math.cos(angle) * pixels);
		turtle.setY(turtle.getY() - Math.sin(angle) * pixels);
		return pixels;
	}

	public double moveTo(double x, double y) {
		double distance = Math.sqrt(Math.pow(turtle.getX() - x, 2) + Math.pow(turtle.getY() - y, 2));
		turtle.setX(x + Workspace.SCENE_WIDTH / 2);
		turtle.setY(Workspace.SCENE_HEIGHT / 2 - y);
		return distance;
	}
}