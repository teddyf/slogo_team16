package model.command.math.trigonometry;

import model.command.Command;

public abstract class MathTrigonometry extends Command {
	public MathTrigonometry() {
		super();
	}
	
	public double sin(double degrees) {
		return Math.sin(degrees*Math.PI/180);
	}
	
	public double cos(double degrees) {
		return Math.cos(degrees*Math.PI/180);
	}
	
	public double atan(double degrees) {
		return Math.atan(degrees*Math.PI/180);
	}
}