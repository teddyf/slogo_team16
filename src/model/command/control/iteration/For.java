/**
 * This is the class for the FOR command
 * 
 * @author Aninda Manocha
 */

package model.command.control.iteration;

import Controller.Data;
import Parsing.ConstantExpression;
import Parsing.ExpressionTree;
import Parsing.TreeNode;
import Parsing.VariableExpression;
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
		Variable variable = new Variable(params[1].getNode().toString(), false);
		Data data = Data.getInstance();
		data.addVariable(variable);
		
		if (((params[2].getNode().expression instanceof ConstantExpression) || (params[2].getNode().expression instanceof VariableExpression))
				&& ((params[3].getNode().expression instanceof ConstantExpression) || (params[3].getNode().expression instanceof VariableExpression))
				&& ((params[4].getNode().expression instanceof ConstantExpression) || (params[4].getNode().expression instanceof VariableExpression))) {
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
		} else {
			super.commandInputError(this.getName());
			return -1;
		}
	}
}