package model.command;

import java.util.ArrayList;

import Controller.Data;
import Parsing.ExpressionTree;
import Parsing.TreeNode;
import model.animal.Animal;
import model.variable.Variable;

public class NewCommand extends ListCommand {
	private final double paramCount;
	private String commandName;
	private ArrayList<String> variableNames;
	private ArrayList<TreeNode> commands;
	
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
	
	private void setParameterValues(Animal turtle, ArrayList<TreeNode> variableNodes) {
		double value = 0;
		String variableName;
		Variable newVariable;
		for (int v = 0; v < variableNodes.size(); v++) {
			variableName = variableNames.get(v);
			value = ExpressionTree.getInstance().process(turtle, variableNodes.get(v));
			newVariable = new Variable(variableName, value);
			Data.getInstance().addLocalVariable(commandName, newVariable);
		}
	}
	
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		ArrayList<TreeNode> variableNodes = params[1].getNodes();
		if (variableNodes.size() == variableNames.size()) {
			setParameterValues(turtle, variableNodes);
		} else {
			// ERROR HANDLING
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
}