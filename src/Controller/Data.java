package Controller;

import java.awt.Color;
import java.util.HashMap;
import java.util.Observable;
import model.command.Command;
import model.variable.Variable;

public class Data extends Observable {
	private static final Data instance = new Data();
	private int numTurtles;
	private HashMap<String, Variable> variables;
	private HashMap<String, Variable> localVariables;
	private HashMap<String, Command> commands;
	private HashMap<Integer, String> colors;
	private HashMap<Integer, String> shapes;
	private String backgroundColor;
	private String penColor;
	private double penSize;
	private double dashValue;
	private String shape;
	
	private Data(){
		numTurtles = 1;
		variables = new HashMap<String,Variable>();
		localVariables = new HashMap<String,Variable>();
		commands = new HashMap<String,Command>();
		colors = new HashMap<Integer,String>();
		colors.put(0, "WHITE");
		colors.put(1, "BLACK");
		colors.put(2, "BLUE");
		colors.put(3, "GREEN");
		colors.put(4, "RED");
		shapes = new HashMap<Integer,String>();
		shapes.put(0, "turtle");
		backgroundColor = "WHITE";
		penColor = "BLACK";
		penSize = 1d;
		dashValue = 1d;
		shape = "";
	}

	public static Data getInstance() {
		return instance;
	}
	
	public int getNumTurtles() {
    	return numTurtles;
    }
    
    public void setNumTurtles(int numTurtles) {
    	this.numTurtles = numTurtles;
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
		setChanged();
		notifyObservers();
	}

	public void changeVariable(String variableName, double value) {
		Variable variable = variables.get(variableName);
		variable.setValue(value);
		setChanged();
		notifyObservers();
	}
	
	/***** LOCAL VARIABLE METHODS *****/

	public Variable getLocalVariable(String variableName) {
		return localVariables.get(variableName);
	}

	public HashMap<String, Variable> getLocalVariables() {
		return localVariables;
	}

	public boolean containsLocalVariable(String variableName) {
		return localVariables.containsKey(variableName);
	}

	public void addLocalVariable(Variable variable) {
		localVariables.put(variable.getName(), variable);
	}

	public void changeLocalVariable(String variableName, double value) {
		Variable variable = localVariables.get(variableName);
		variable.setValue(value);
	}
	
	public void clearLocalVariables() {
		localVariables = new HashMap<String,Variable>();
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

	/***** SHAPE METHODS *****/
	
	public String getShape(int index) {
		return shapes.get(index);
	}

	public HashMap<Integer, String> getShapes() {
		return shapes;
	}

	public boolean containsShape(String shape) {
		return shapes.containsValue(shape);
	}

	public void addShape(int index, String shape) {
		shapes.put(index, shape);
	}

	public void changeShape(int index, String shape) {
		addShape(index, shape);
	}
	
	/***** GUI METHODS *****/

	public String getBackgroundColor() {
		System.out.println("Get background: "+backgroundColor);
		return backgroundColor;
	}

	public String getPenColor() {
		return penColor;
	}

	public int getPenColorIndex(String color) {
		for (int i = 0; i < colors.size(); i++) {
			if (color.equals(colors.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	public double getPenSize() {
		return penSize;
	}
	
	public String getShape() {
		return shape;
	}

	public double getDashValue() {
		return dashValue;
	}
	
	public int getShapeIndex(String shape) {
		for (int i = 0; i < shapes.size(); i++) {
			if (shape.equals(shapes.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	public void setBackgroundColor(int index) {
		if (colors.containsKey(index)) {
			this.backgroundColor = colors.get(index);
			setChanged();
			notifyObservers();
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

	public void setDashValue(double dashValue) {
		this.dashValue = dashValue;
	}
	
	public void setShape(int index) {
		if (shapes.containsKey(index)) {
			this.shape = shapes.get(index);
			setChanged();
			notifyObservers();
		} else {
			// ERROR HANDLING
		}
	}
	
	public void setPalette(int index, int r, int g, int b) {
		Color color = new Color(r, g, b);
		String colorName = color.toString();
		changeColor(index, colorName);
	}
}