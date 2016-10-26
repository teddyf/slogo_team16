package model.command.turtle.movement;

import View.Workspace;
import model.animal.Animal;
import model.command.turtle.TurtleCommand;

public abstract class TurtleMovement extends TurtleCommand {
	public TurtleMovement() {
		super();
	}

	public double move(Animal turtle, double pixels) {
		double angle = 90 - turtle.getHeading();
		turtle.setX(turtle.getX() + Math.cos(angle*Math.PI/180) * pixels);
		turtle.setY(turtle.getY() - Math.sin(angle*Math.PI/180) * pixels);
		return pixels;
	}

	public double moveTo(Animal turtle, double x, double y) {
		double turtleX = turtle.getX() - Workspace.LEFT_PANE_WIDTH/2;
		double turtleY = Workspace.LEFT_PANE_HEIGHT/2 - turtle.getY();
		double distance = Math.sqrt(Math.pow(turtleX - x, 2) + Math.pow(turtleY - y, 2));
		turtle.setX(x + Workspace.LEFT_PANE_WIDTH / 2);
		turtle.setY(Workspace.LEFT_PANE_HEIGHT / 2 - y);
		return distance;
	}
}