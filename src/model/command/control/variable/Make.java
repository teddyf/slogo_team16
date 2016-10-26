package model.command.control.variable;

import model.DataSingleton;
import model.command.Command;
import model.command.Parameter;
import model.variable.Variable;

public class Make extends Command {
	private final double paramCount;
	
	public Make() {
		super();
		numParams = 2;
		paramCount = 2;
	}
	
	/**
	 * Assigns a value to a variable or creates the variable if it doesn't already exist
	 * @param params - array of parameters
	 * @return the value of the variable
	 */
	@Override
	public double run(Parameter[] params) {
		String variableName = params[0].getName();
		double expression = params[1].getValue();
		DataSingleton data = DataSingleton.getInstance();
		
		if (data.containsVariable(variableName)) {
			data.changeVariable(variableName, expression);
		} else {
			data.addVariable(new Variable(variableName, expression));
		}
		
		return expression;
	}
}