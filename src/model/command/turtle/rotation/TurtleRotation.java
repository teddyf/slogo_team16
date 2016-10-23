package model.command.turtle.rotation;

import model.animal.Animal;
import model.command.Command;

public abstract class TurtleRotation extends Command {
	public TurtleRotation() {
		super();
	}

	public double turn(Animal turtle, double degrees, double left) {
		turtle.setHeading(turtle.getHeading() + degrees);
		turtle.setHeading(turtle.getHeading() % 360);
		if (left == 1) {
			if (turtle.getHeading() < 0) {
				turtle.setHeading(360 - turtle.getHeading());
			}
		}
		return degrees;
	}

	public double turnTo(Animal turtle, double heading) {
		heading = heading % 360;
		turtle.setHeading(heading);
		double diff = Math.abs(turtle.getHeading() - heading);
		if (diff <= 180) {
			return diff;
		} else {
			return 360 - diff;
		}
	}

	public double turnTo(Animal turtle, double x, double y) {
		double x_diff = x - turtle.getX();
		double y_diff = y - turtle.getY();
		double heading = Math.atan2(y_diff, x_diff);
		return turnTo(turtle, heading);
	}
}