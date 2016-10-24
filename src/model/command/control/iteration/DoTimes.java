package model.command.control.iteration;

import model.DataSingleton;
import model.command.Command;
import model.command.Parameter;
import model.variable.Variable;

public class DoTimes extends Command {
	private final double paramCount;
	
	public DoTimes() {
		super();
		numParams = 4;
		paramCount = 4;
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
		double limit = params[1].getValue();
		Command[] commands = (Command[])params[2].getList();
		Parameter[][] parameters = (Parameter[][])params[3].getList();
		
		Command command;
		double value = 0;
		
		for(int i = 0; i < limit; i++) {
			for(int c = 0; c < commands.length; c++) {
				command = commands[c];
				value = command.run(parameters[c]);
				variable.setValue(i+1);
			}
		}
		
		return value;
	}
}