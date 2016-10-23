package model.command.control.variable;

import model.DataSingleton;
import model.command.Command;
import model.command.Parameter;
import model.variable.Variable;

public class To extends Command {
	private final double numParams = 3;
	
	public To() {
		super();
	}
	
	/**
	 * Assigns a value to a variable or creates the variable if it doesn't already exist
	 * @param params - array of parameters
	 * @return the value of the variable
	 */
	@Override
	public double run(Parameter[] params) {
		String commandName = params[0].getName();
		String[] variableNames = (String[])params[1].getList();
		Variable[] variables = new Variable[variableNames.length]; 
		for(int v = 0; v < variables.length; v++) {
			variables[v] = new Variable(variableNames[v]);
		}
		Command[] commands = (Command[])params[2].getList();
		DataSingleton data = DataSingleton.getInstance();
		
		Command command;
		double value = 0;
		
		
		return value;
	}
}