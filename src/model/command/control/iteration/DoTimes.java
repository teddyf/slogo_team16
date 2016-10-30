package model.command.control.iteration;

import Controller.Data;
import Parsing.ExpressionTree;
import Parsing.TreeNode;
import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;
import model.variable.Variable;

public class DoTimes extends Command {
	private final double paramCount;
	
	public DoTimes() {
		super();
		numParams = 4;
		paramCount = Double.POSITIVE_INFINITY; //was 3
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
		Data data = Data.getInstance();
		data.addVariable(variable);
		double limit = ExpressionTree.getInstance().process(turtle, params[2].getNode());
		TreeNode node = params[3].getNode();
		
		double value = 0;
		
		for(int i = 0; i < limit; i++) {
			value = ExpressionTree.getInstance().process(turtle, node);
			variable.setValue(i+1);
		}
		
		return value;
	}
}