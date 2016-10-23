package model.command;

public abstract class Command {

	public Command() {
	}

	public abstract double run(Parameter[] params);
	
	public String getName() { 
		return this.getClass().getName();
	}
}