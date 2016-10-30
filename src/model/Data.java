package model;

import java.util.HashMap;
import model.command.Command;
import model.variable.Variable;

public class Data {
	private static final Data instance = new Data();
	private HashMap<String,Variable> variables;
	private HashMap<String,Command> commands;
	
	private Data(){
		variables = new HashMap<String,Variable>();
		commands = new HashMap<String,Command>();
	}
	
	public static Data getInstance() {
		return instance;
	}
	
	/*****VARIABLE METHODS*****/
	
	public Variable getVariable(String variableName) {
		return variables.get(variableName);
	}
	
	public boolean containsVariable(String variableName) {
		return variables.containsKey(variableName);
	}
	
	public void addVariable(Variable variable) {
		variables.put(variable.getName(), variable);
	}
	
	public void changeVariable(String variableName, double value) {
		Variable variable = variables.get(variableName);
		variable.setValue(value);
	}
	
	/*****COMMAND METHODS*****/
	
	public Command getCommand(String commandName) {
		return commands.get(commandName);
	}
	
	public boolean containsCommand(String commandName) {
		return commands.containsKey(commandName);
	}
	
	public void addCommand(Command command) {
		commands.put(command.getName(), command);
	}
	
	public void changeCommand(String commandName, Command command) {
		commands.put(commandName, command);
	}
}