package model.command.control.iteration;

import model.command.Command;
import model.command.Parameter;
import model.variable.Variable;

public class DoTimes extends Command {
	private final double numParams = 4;
	
	public DoTimes() {
		super();
	}
	
	/**
	 * Runs a set of commands for each value specified in a range
	 * @param params - array of parameters
	 * @return the value of the final command executed or 0 if no command is executed
	 */
	@Override
	public double run(Parameter[] params) {
		Variable variable = new Variable(params[0].getName());
		double limit = params[1].getValue();
		Command[] commands = params[2].getCommands();
		Parameter[][] parameters = params[3].getParameters();
		
		Command command;
		double value = 0;
		
		for(int i = 0; i < limit; i++) {
			for(int c = 0; c < commands.length; c++) {
				command = commands[c];
				value = command.run(parameters[c]);
				variable.setValue(value);
			}
		}
		
		return value;
	}
}