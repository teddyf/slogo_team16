package model.command;

import java.util.Arrays;

public class NewCommand extends Command {
	private String commandName;
	private String[] variableNames;
	private Command[] commands;
	private Parameter[][] parameters;
	private Parameter[][] parameterValues;
	
	public NewCommand() {
		super();
		numParams = 1;
	}
	
	public NewCommand(String commandName, String[] variableNames, Command[] commands, Parameter[][] parameters) {
		this.commandName = commandName;
		this.variableNames = variableNames;
		this.commands = commands;
		this.parameters = parameters;
		this.parameterValues = parameters;
	}
	
	private void setParameterValues(Double[] variables) {
		for (int v = 0; v < variableNames.length; v++) {
			for (int p = 0; p < parameters.length; p++) {
				for (int i = 0; i < parameters[p].length; i++) {
					if (Arrays.asList(parameters[p]).contains(variableNames[v])) {
						parameterValues[p][i].setValue(variables[v]);
					}
					
				}
			}
		}
	}
	
	@Override
	public double run(Parameter[] params) {
		Double[] variables = (Double[])params[0].getList();
		setParameterValues(variables);
		Command command;
		double value = 0;
		for(int c = 0; c < commands.length; c++) {
			command = commands[c];
			value = command.run(parameterValues[c]);
		}
		return value;
	}
	
	@Override
	public String getName() {
		return commandName;
	}
}