package Controller;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import View.helper.Colors;
import model.command.Command;
import model.variable.Variable;

public class Data extends Observable {
	private static final Data instance = new Data();
	private int numTurtles;
	private HashMap<String, Variable> variables;
	private HashMap<String, UserCommand> commands;
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
		commands = new HashMap<String,UserCommand>();
		colors = new HashMap<Integer,String>();
		populateColorsMap();
		shapes = new HashMap<Integer,String>();
		shapes.put(0, "turtle");
		backgroundColor = Colors.WHITE.toString();
		penColor = Colors.BLACK.toString();
		penSize = 1d;
		dashValue = 1d;
		shape = "";
	}

	private void populateColorsMap() {
		colors.put(Colors.WHITE.getId(), Colors.WHITE.toString());
		colors.put(Colors.BLACK.getId(), Colors.BLACK.toString());
		colors.put(Colors.BLUE.getId(), Colors.BLUE.toString());
		colors.put(Colors.GREEN.getId(), Colors.GREEN.toString());
		colors.put(Colors.RED.getId(), Colors.RED.toString());
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

	public Map<String, Variable> getVariables() {
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

	/***** COMMAND METHODS *****/

	public Command getCommand(String commandName) {
		return commands.get(commandName).getCommand();
	}
	
	public HashMap<String,UserCommand> getCommands() {
		return commands;
	}

	public boolean containsCommand(String commandName) {
		return commands.containsKey(commandName);
	}

	public void addCommand(Command command) {
		commands.put(command.getName(), new UserCommand(command));
	}

	public void changeCommand(String commandName, Command command) {
		commands.put(commandName, new UserCommand(command));
	}
	
	/***** LOCAL VARIABLE METHODS *****/

	public Variable getLocalVariable(String commandName, String variableName) {
		return commands.get(commandName).getLocalVariables().get(variableName);
	}

	public HashMap<String, Variable> getLocalVariables(String commandName) {
		return commands.get(commandName).getLocalVariables();
	}

	public boolean containsLocalVariable(String commandName, String variableName) {
		return commands.get(commandName).getLocalVariables().containsKey(variableName);
	}

	public void addLocalVariable(String commandName, Variable variable) {
		commands.get(commandName).getLocalVariables().put(variable.getName(), variable);
	}

	public void changeLocalVariable(String commandName, String variableName, double value) {
		Variable variable = commands.get(commandName).getLocalVariables().get(variableName);
		variable.setValue(value);
	}
	
	public void clearLocalVariables(String commandName) {
		commands.get(commandName).setLocalVariables(new HashMap<String,Variable>());
	}
	
	/***** COLOR METHODS *****/

	public String getColor(int index) {
		return colors.get(index);
	}

	public Map<Integer, String> getColors() {
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

	public Map<Integer, String> getShapes() {
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