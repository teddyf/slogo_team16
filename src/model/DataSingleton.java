package model;

import java.util.HashMap;
import model.command.Command;
import model.variable.Variable;

public class DataSingleton {
	private static final DataSingleton instance = new DataSingleton();
	private HashMap<String,Variable> variables;
	private HashMap<String,Command> commands;
	
	private DataSingleton(){
		variables = new HashMap<String,Variable>();
		commands = new HashMap<String,Command>();
	}
	
	public static DataSingleton getInstance() {
		return instance;
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
	
	public boolean containsCommand(String commandName) {
		return commands.containsKey(commandName);
	}
}