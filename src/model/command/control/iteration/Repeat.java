package model.command.control.iteration;

import model.DataSingleton;
import model.command.Command;
import model.command.Parameter;
import model.variable.Variable;

public class Repeat extends Command {
	private final double paramCount;
	
	public Repeat() {
		super();
		numParams = 2;
		paramCount = 2;
	}
	
	/**
	 * Runs a set of commands a given number of times
	 * @param params - array of parameters
	 * @return the value of the final command executed or 0 if no command is executed
	 */
	@Override
	public double run(Parameter[] params) {
		double expression = params[0].getValue();
		Command[] commands = (Command[])params[1].getList();
		Parameter[][] parameters = (Parameter[][])params[2].getList();
		
		Command command;
		double value = 0;
		DataSingleton data = DataSingleton.getInstance();
		Variable repCount = new Variable("repcount");
		data.addVariable(repCount);
		
		for(int i = 0; i < expression; i++) {
			for(int c = 0; c < commands.length; c++) {
				command = commands[c];
				value = command.run(parameters[c]);
			}
			repCount.setValue(i+1);
		}
		
		return value;
	}
}