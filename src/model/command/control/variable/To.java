package model.command.control.variable;

import java.util.Arrays;
import model.DataSingleton;
import model.command.Command;
import model.command.NewCommand;
import model.command.Parameter;
import model.variable.Variable;

public class To extends Command {
	private final double numParams = 4;
	
	public To() {
		super();
	}
	
	/**
	 * Creates a new command given variables and commands to run
	 * @param params - array of parameters
	 * @return 1 if the command is successfully defined and 0 otherwise
	 */
	@Override
	public double run(Parameter[] params) {
		DataSingleton data = DataSingleton.getInstance();
		String commandName = params[0].getName();
		if (data.containsCommand(commandName)) {
			return 0; //IMPLEMENT ERROR CHECKING
		}
		String[] variableNames = (String[])params[1].getList();
		Command[] commands = (Command[])params[2].getList();
		Parameter[][] parameters = (Parameter[][])params[3].getList();
		
		Command newCommand = new NewCommand(commandName, variableNames, commands, parameters);
		data.addCommand(newCommand);
		
		return 1;
	}
}