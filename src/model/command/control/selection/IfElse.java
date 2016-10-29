package model.command.control.selection;

import Parsing.ExpressionTree;
import Parsing.TreeNode;
import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;

public class IfElse extends Command {
	private final double paramCount;
	
	public IfElse() {
		super();
		numParams = 4;
		paramCount = 3;
	}
	
	/**
	 * Runs a set commands if a given expression is not 0 and a different set of commands otherwise
	 * @param params - array of parameters
	 * @return the value of the final command executed or 0 if no command is executed
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double expression = params[1].getValue();
		TreeNode trueNode = params[2].getNode();
		TreeNode falseNode = params[3].getNode();
		
		double value = 0;
		if (expression != 0) {
			value = ExpressionTree.getInstance().process(turtle, trueNode);
			return value;
		} else {
			value = ExpressionTree.getInstance().process(turtle, falseNode);
			return value;
		}
	}
}