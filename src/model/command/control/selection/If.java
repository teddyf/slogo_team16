package model.command.control.selection;

import java.util.ArrayList;
import Parsing.TreeNode;
import model.animal.Animal;
import model.command.Command;
import model.command.CommandProcessor;
import model.command.Parameter;

public class If extends Command {
	private final double paramCount;
	
	public If() {
		super();
		numParams = 2;
		paramCount = 2;
	}
	
	/**
	 * Runs commands if a given expression is not 0
	 * @param params - array of parameters
	 * @return the value of the final command executed or 0 if no command is executed
	 */
	@Override
	public double run(Parameter[] params) {
		double expression = params[0].getValue();
		Animal turtle = params[1].getAnimal();
		ArrayList<TreeNode> nodes = params[2].getNodes();
		
		double value = 0;
		if (expression != 0) {
			CommandProcessor processor = new CommandProcessor();
			processor.processCommands(turtle, nodes);
			ArrayList<Command> commands = processor.getCommands();
			ArrayList<Parameter[]> parameters = processor.getParameters();
			Command command;
			for(int c = 0; c < commands.size(); c++) {
				command = commands.get(c);
				value = command.run(parameters.get(c));
			}
			return value;
		} else {
			return 0;
		}
	}
}