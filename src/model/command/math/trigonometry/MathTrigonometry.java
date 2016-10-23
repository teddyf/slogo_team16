package Model.command.math.trigonometry;

import Model.command.math.MathCommand;

public abstract class MathTrigonometry extends MathCommand {
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