package model.command;

public abstract class Command {
	protected double numParams;
	
	public Command() {
	}

	public abstract double run(Parameter[] params);
	
	public String getName() { 
		return this.getClass().getSimpleName();
	}
	
	public double getNumParams() {
		return numParams;
	}
}