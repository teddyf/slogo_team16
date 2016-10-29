package model.command.control.selection;

import java.util.ArrayList;

import Parsing.ExpressionTree;
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
		paramCount = Double.POSITIVE_INFINITY; //was 2
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
		TreeNode node = params[2].getNode();
		
		double value = 0;
		if (expression != 0) {
			value = ExpressionTree.getInstance().process(turtle, node);
			return value;
		} else {
			return 0;
		}
	}
}