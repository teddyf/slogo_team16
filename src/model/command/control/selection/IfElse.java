package model.command.control.selection;

import model.command.Command;
import model.command.Parameter;

public class IfElse extends Command {
	private final double paramCount;
	
	public IfElse() {
		super();
		numParams = 3;
		paramCount = Double.POSITIVE_INFINITY; //was 3
	}
	
	/**
	 * Runs a set commands if a given expression is not 0 and a different set of commands otherwise
	 * @param params - array of parameters
	 * @return the value of the final command executed or 0 if no command is executed
	 */
	@Override
	public double run(Parameter[] params) {
		double expression = params[0].getValue();
		Command[] trueCommands = (Command[])params[1].getList();
		Command[] falseCommands = (Command[])params[2].getList();
		Parameter[][] trueParameters = (Parameter[][])params[3].getList();
		Parameter[][] falseParameters = (Parameter[][])params[4].getList();
		
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