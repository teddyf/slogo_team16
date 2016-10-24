package model.command.control.iteration;

import model.DataSingleton;
import model.command.Command;
import model.command.Parameter;
import model.variable.Variable;

public class For extends Command {
	public For() {
		super();
		numParams = 6;
	}
	
	/**
	 * Runs a set of commands for each value specified in a range
	 * @param params - array of parameters
	 * @return the value of the final command executed or 0 if no command is executed
	 */
	@Override
	public double run(Parameter[] params) {
		Variable variable = new Variable(params[0].getName());
		DataSingleton data = DataSingleton.getInstance();
		data.addVariable(variable);
		double start = params[1].getValue();
		double end = params[2].getValue();
		double increment = params[3].getValue();
		Command[] commands = (Command[])params[4].getList();
		Parameter[][] parameters = (Parameter[][])params[5].getList();
		
		Command command;
		double value = 0;
		
		for(int i = (int)start; i < end; i+=increment) {
			for(int c = 0; c < commands.length; c++) {
				command = commands[c];
				value = command.run(parameters[c]);
				variable.setValue(i+1);;
			}
		}
		
		return value;
	}
}