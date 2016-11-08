package model.command;

import java.util.ArrayList;

import Controller.Data;
import ErrorHandling.Error;
import Parsing.TreeNode;
import Parsing.expression.ExpressionTree;
import model.animal.Animal;
import model.variable.Variable;

/**
 * This is the class for a user-defined command. If the user enters the wrong type of data, it is read in as the name of a 
 * command, so error handling is implemented in this class as well to account for when the user enters names that are not the 
 * names of any commands.
 * 
 * @author Aninda Manocha
 */

public class NewCommand extends ListCommand {
	private final double paramCount;
	private String commandName;
	private ArrayList<String> variableNames;
	private ArrayList<TreeNode> commands;
	
	/***** CONSTRUCTORS *****/
	
	public NewCommand() {
		super();
		numParams = 2;
		paramCount = 1;
	}
	
	public NewCommand(String commandName, ArrayList<String> variableNames, ArrayList<TreeNode> commands) {
		this.commandName = commandName;
		this.variableNames = variableNames;
		this.commands = commands;
		numParams = 2;
		paramCount = 1;
	}
	
	/**
	 * Sets the values of variables to the values that are inputted
	 * @param turtle - the turtle the commands are running on
	 * @param variableNodes - the list of variable values
	 */
	private void setParameterValues(Animal turtle, ArrayList<TreeNode> variableNodes) {
		double value = 0;
		String variableName;
		Variable newVariable;
		for (int v = 0; v < variableNodes.size(); v++) {
			variableName = variableNames.get(v);
			value = ExpressionTree.getInstance().process(turtle, variableNodes.get(v));
			newVariable = new Variable(variableName, value, true);
			Data.getInstance().addLocalVariable(commandName, newVariable);
		}
	}
	
	/**
	 * Runs the defined command with the values that are inputted
	 * @param params - array of parameters
	 * @return the value of the last command run
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		ArrayList<TreeNode> variableNodes = params[1].getNodes();
		if (variableNodes.size() == variableNames.size()) {
			setParameterValues(turtle, variableNodes);
		} else { //throw error if incorrect data types are entered
			Error.getInstance().displayError("Argument Mismath Error!", "Invalid Number of Arguments Entered", 
					"The number of arguments entered does not match the number of arguments for this command.");
		}
		
		double value = 0;
		for(int c = 0; c < commands.size(); c++) {
			value = ExpressionTree.getInstance().process(turtle, commands.get(c));
		}
		return value;
	}
	
	@Override
	public String getName() {
		return commandName;
	}
	
	@Override 
	public double getNumParams() {
		return numParams;
	}
}