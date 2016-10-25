package model.command.turtle.rotation;

import View.Workspace;
import model.animal.Animal;
import model.command.turtle.TurtleCommand;

public abstract class TurtleRotation extends TurtleCommand {
	public TurtleRotation() {
		super();
	}

	public double turn(Animal turtle, double degrees, double left) {
		turtle.setHeading(turtle.getHeading() + degrees);
		turtle.setHeading(turtle.getHeading() % 360);
		if (left == 1) {
			if (turtle.getHeading() < 0) {
				turtle.setHeading(360 + turtle.getHeading());
			}
		}
		return degrees;
	}

	public double turnTo(Animal turtle, double heading) {
		heading = heading % 360;
		double diff = Math.abs(turtle.getHeading() - heading);
		turtle.setHeading(heading);
		if (diff <= 180) {
			return diff;
		} else {
			return 360 - diff;
		}
	}

	public double turnTo(Animal turtle, double x, double y) {
		double x_diff = x - (turtle.getX() - Workspace.LEFT_PANE_WIDTH/2);
		double y_diff = y - (Workspace.LEFT_PANE_HEIGHT/2 - turtle.getY());
		System.out.println("x diff " + x_diff);
		System.out.println("y diff " + y_diff);
		double heading = 90 - Math.atan2(y_diff, x_diff)*180/Math.PI;
		return turnTo(turtle, heading);
	}
}