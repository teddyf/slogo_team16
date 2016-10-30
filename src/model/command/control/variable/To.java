package model.command.control.variable;

import Parsing.ExpressionTree;
import Parsing.TreeNode;
import model.Data;
import model.animal.Animal;
import model.command.Command;
import model.command.NewCommand;
import model.command.Parameter;
import model.command.control.ControlCommand;

public class To extends ControlCommand {
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
		String[] variableNames = (String[])params[2].getVariables();
		TreeNode node = params[3].getNode();
		
		Command newCommand = new NewCommand(commandName, variableNames, node);
		data.addCommand(newCommand);
		
		return 1;
	}
}