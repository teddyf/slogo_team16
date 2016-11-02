/**
 * This is the Data class that holds all data and is a singleton so that all classes can access the data.
 * 
 * @author Aninda Manocha
 */

package Controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import ErrorHandling.Errors;
import View.helper.Colors;
import model.animal.Animal;
import model.command.Command;
import model.variable.Variable;

public class Data extends Observable {
	private static final Data instance = new Data();
	private int numTurtles;
	private int workspaceID;
	private HashMap<Integer,ArrayList<Animal>> turtles;
	private HashMap<String, Variable> variables;
	private HashMap<String, UserCommand> commands;
	private HashMap<Integer, String> colors;
	private HashMap<Integer, String> shapes;
	private String backgroundColor;
	private String penColor;
	private double penSize;
	private double dashValue;
	private String shape;
	private boolean clearScreen;
	
	private Data(){
		numTurtles = 1;
		workspaceID = 1;
		turtles = new HashMap<Integer,ArrayList<Animal>>();
		turtles.put(1, new ArrayList<Animal>());
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
		this.clearScreen = false;
	}

	/**
	 * Instance of the data class
	 * @return the instance
	 */
	public static Data getInstance() {
		return instance;
	}
	
	/**
	 * Set default colors for palette
	 */
	private void populateColorsMap() {
		colors.put(Colors.WHITE.getId(), Colors.WHITE.toString());
		colors.put(Colors.BLACK.getId(), Colors.BLACK.toString());
		colors.put(Colors.BLUE.getId(), Colors.BLUE.toString());
		colors.put(Colors.GREEN.getId(), Colors.GREEN.toString());
		colors.put(Colors.RED.getId(), Colors.RED.toString());
	}
	
	/***** CLEAR SCREEN METHODS *****/
	
	public boolean getClearScreen(){
		return this.clearScreen;
	}
	
	public void setClearScreen(boolean bool){
		this.clearScreen = bool;
	}
	
	/***** NUMBER OF TURTLES METHODS *****/
	
	public int getNumTurtles() {
    	return numTurtles;
    }
    
    public void setNumTurtles(int numTurtles) {
    	this.numTurtles = numTurtles;
    }
    
    /****** WORKSPACE ID METHODS *****/
    
    public int getWorkspaceID() {
    	return workspaceID;
    }
    
    public void setWorkspaceID(int workspaceID) {
    	this.workspaceID = workspaceID;
    }
    
    /***** TURTLE METHODS *****/
    
    public Animal getTurtle(int id) {
    	for (int t = 0; t < turtles.size(); t++) {
    		if (turtles.get(workspaceID).get(t).getId() == id) {
    			return turtles.get(workspaceID).get(t);
    		}
    	}
    	return null;
    }
    
    public ArrayList<Animal> getTurtles() {
    	return this.turtles.get(workspaceID);
    }
    
    public void addTurtle(Animal turtle) {
    	this.turtles.get(workspaceID).add(turtle);
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
	
	public void setShape(int index) {
		if (shapes.containsKey(index)) {
			this.shape = shapes.get(index);
			setChanged();
			notifyObservers();
		}
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

	/**
	 * Gets the index in the map (palette) of pen colors pertaining to a specific color
	 * @param color - color of pen
	 * @return index of pen 
	 */
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
	
	/**
	 * Gets the shape of the turtle
	 * @return shape
	 */
	public String getShape() {
		return shape;
	}
	
	public void setBackgroundColor(int index) {
		if (colors.containsKey(index)) {
			System.out.println("setbackgroundcolor contains key");
			this.backgroundColor = colors.get(index);
			setChanged();
			notifyObservers();
		} else {
			Errors.getInstance().displayError("Index Error!", "Invalid Index", "There is no color at that index.");
		}
	}

	/**
	 * Gets the pen type (solid, dashed, or dotted)
	 * @return pen type
	 */
	public double getDashValue() {
		return dashValue;
	}
	
	public void setPenColor(int index) {
		if (colors.containsKey(index)) {
			this.penColor = colors.get(index);
			setChanged();
			notifyObservers();
		} else {
			Errors.getInstance().displayError("Index Error!", "Invalid Index", "There is no color at that index.");
		}
	}
	
	public void setPenSize(int pixels) {
		this.penSize = pixels;
		setChanged();
		notifyObservers();
	}

	public void setDashValue(double dashValue) {
		this.dashValue = dashValue;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Gets the index in the map of shapes pertaining to a specific shape
	 * @param shape - the specified shape
	 * @return the index
	 */
	public int getShapeIndex(String shape) {
		for (int i = 0; i < shapes.size(); i++) {
			if (shape.equals(shapes.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Sets the color at an index to a color with given amounts of red, green, and blue
	 * @param index - index in color map (palette)
	 * @param r - amount of red
	 * @param g - amount of green
	 * @param b - amount of blue
	 */
	public void setPalette(int index, int r, int g, int b) {
		Color color = new Color(r, g, b);
		String colorName = color.toString();
		changeColor(index, colorName);
	}
}