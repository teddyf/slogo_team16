package Controller;

import java.util.HashMap;
import java.util.Observable;

import View.helper.UIDataUpdate;
import model.command.Command;
import model.variable.Variable;

public class Data extends Observable {
	private static final Data instance = new Data();
	private HashMap<String, Variable> variables;
	private HashMap<String, Command> commands;
	private HashMap<Integer, String> colors;
	private String backgroundColor;
	private String penColor;
	private int penSize;

	
	private Data(){
		variables = new HashMap<String,Variable>();
		commands = new HashMap<String,Command>();
		colors = new HashMap<Integer,String>();
		colors.put(0, "WHITE");
		colors.put(1, "BLACK");
		colors.put(2, "BLUE");
		colors.put(3, "GREEN");
		colors.put(4, "RED");
		backgroundColor = "WHITE";
		penColor = "BLACK";
		penSize = 1;
		
	}

	public static Data getInstance() {
		return instance;
	}

	/***** VARIABLE METHODS *****/

	public Variable getVariable(String variableName) {
		return variables.get(variableName);
	}

	public HashMap<String, Variable> getVariables() {
		return variables;
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

	/***** COMMAND METHODS *****/

	public Command getCommand(String commandName) {
		return commands.get(commandName);
	}

	public HashMap<String, Command> getCommands() {
		return commands;
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

	/***** COLOR METHODS *****/

	public String getColor(int index) {
		return colors.get(index);
	}

	public HashMap<Integer, String> getColors() {
		return colors;
	}

	public boolean containsColor(String color) {
		return colors.containsValue(color);
	}

	public void addColor(int index, String color) {
		colors.put(index, color);
	}

	public void changeColor(int index, String color) {
		addColor(index, color);
	}

	/***** GUI METHODS *****/

	public String getBackgroundColor() {
		System.out.println("Get background: "+backgroundColor);
		return backgroundColor;
	}

	public String getPenColor() {
		return penColor;
	}
	public int getPenSize() {
		return penSize;
	}
	
	public void setBackgroundColor(int index) {
		System.out.println("setting background");
		setChanged();
		notifyObservers();
		if (colors.containsKey(index)) {
			this.backgroundColor = colors.get(index);
		} else {
			// ERROR HANDLING
		}
	}

	public void setPenColor(int index) {
		if (colors.containsKey(index)) {
			this.penColor = colors.get(index);
		} else {
			// ERROR HANDLING
		}
	}
	
	public void setPenSize(int pixels) {
		this.penSize = pixels;
	}
}