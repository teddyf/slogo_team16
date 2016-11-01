package model.command.control.variable;

import java.util.ArrayList;

import Controller.Data;
import Parsing.ExpressionTree;
import Parsing.TreeNode;
import model.animal.Animal;
import model.command.Command;
import model.command.ListCommand;
import model.command.NewCommand;
import model.command.Parameter;

public class To extends ListCommand {
	private final double paramCount;
	
	public To() {
		super();
		numParams = 4;
		paramCount = 3;
	}
	
	/**
	 * Creates a new command given variables and commands to run
	 * @param params - array of parameters
	 * @return 1 if the command is successfully defined and 0 otherwise
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		Data data = Data.getInstance();
		String commandName = params[1].getNode().toString();
		if (data.containsCommand(commandName)) {
			return 0; //IMPLEMENT ERROR CHECKING
		}
		ArrayList<String> variableNames = new ArrayList<String>();
		ArrayList<TreeNode> variableNodes = params[2].getNodes();
		for (int n = 0; n < variableNodes.size(); n++) {
			variableNames.add(variableNodes.get(n).toString());
		}
		ArrayList<TreeNode> commands = params[3].getNodes();
		Command newCommand = new NewCommand(commandName, variableNames, commands);
		data.addCommand(newCommand);
		
		return 1;
	}
}