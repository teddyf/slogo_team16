package model.command.control.selection;

import model.command.Command;
import model.command.Parameter;

public class IfElse extends Command {
	private final double numParams = 3;
	
	public IfElse() {
		super();
	}
	
	/**
	 * Runs a set commands if a given expression is not 0 and a different set of commands otherwise
	 * @param params - array of parameters
	 * @return the value of the final command executed or 0 if no command is executed
	 */
	@Override
	public double run(Parameter[] params) {
		double expression = params[0].getValue();
		Command[] trueCommands = params[1].getCommands();
		Command[] falseCommands = params[2].getCommands();
		Parameter[][] trueParameters = params[3].getParameters();
		Parameter[][] falseParameters = params[4].getParameters();
		
		Command[] commands;
		Parameter[][] parameters;
		Command command;
		double value = 0;
		if (expression != 0) {
			commands = trueCommands;
			parameters = trueParameters;
		} else {
			commands = falseCommands;
			parameters = falseParameters;
		}
		
		for(int c = 0; c < commands.length; c++) {
			command = commands[c];
			value = command.run(parameters[c]);
		}
		
		return value;
	}
}