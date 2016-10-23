package model.command.control.selection;

import model.command.Command;
import model.command.Parameter;

public class If extends Command {
	private final double numParams = 2;
	
	public If() {
		super();
	}
	
	/**
	 * Runs commands if a given expression is not 0
	 * @param params - array of parameters
	 * @return the value of the final command executed or 0 if no command is executed
	 */
	@Override
	public double run(Parameter[] params) {
		double expression = params[0].getValue();
		Command[] commands = params[1].getCommands();
		Parameter[][] parameters = params[2].getParameters();
		
		Command command;
		double value = 0;
		if (expression != 0) {
			for(int c = 0; c < commands.length; c++) {
				command = commands[c];
				value = command.run(parameters[c]);
			}
			return value;
		} else {
			return 0;
		}
	}
}