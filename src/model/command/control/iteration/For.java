package model.command.control.iteration;

import Parsing.ExpressionTree;
import Parsing.TreeNode;
import model.DataSingleton;
import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;
import model.variable.Variable;

public class For extends Command {
	private final double paramCount;
	
	public For() {
		super();
		numParams = 6;
		paramCount = Double.POSITIVE_INFINITY; //5
	}
	
	/**
	 * Runs a set of commands for each value specified in a range
	 * @param params - array of parameters
	 * @return the value of the final command executed or 0 if no command is executed
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		Variable variable = new Variable(params[1].getNode().toString());
		DataSingleton data = DataSingleton.getInstance();
		data.addVariable(variable);
		double start = ExpressionTree.getInstance().process(turtle, params[2].getNode());
		double end = ExpressionTree.getInstance().process(turtle, params[3].getNode());
		double increment = ExpressionTree.getInstance().process(turtle, params[4].getNode());
		TreeNode node = params[5].getNode();
		
		double value = 0;
		
		for(int i = (int)start; i <= end; i+=increment) {
			value = ExpressionTree.getInstance().process(turtle, node);
			variable.setValue(i+1);
		}
		
		return value;
	}
}