package model.command.control.variable;

import Parsing.TreeNode;
import model.DataSingleton;
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
		DataSingleton data = DataSingleton.getInstance();
		String commandName = params[1].getName();
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