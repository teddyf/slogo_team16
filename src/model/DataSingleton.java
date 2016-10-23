package model;

import java.util.HashMap;
import model.variable.Variable;

public class DataSingleton {
	private static final DataSingleton instance = new DataSingleton();
	private HashMap<String,Variable> variables;
	
	private DataSingleton(){
		variables = new HashMap<String,Variable>();
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
}