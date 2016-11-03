/**
 * This is the class for the REPEAT command
 * 
 * @author Aninda Manocha
 */

package model.command.control.iteration;

import Controller.Data;
import Parsing.TreeNode;
import Parsing.expression.ConstantExpression;
import Parsing.expression.ExpressionTree;
import Parsing.expression.VariableExpression;
import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;
import model.variable.Variable;

public class Repeat extends Command {
	private final double paramCount;
	
	public Repeat() {
		super();
		numParams = 3;
		paramCount = Double.POSITIVE_INFINITY; //was 2
	}
	
	/**
	 * Runs a set of commands a given number of times
	 * @param params - array of parameters
	 * @return the value of the final command executed or 0 if no command is executed
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression))) {
			double expression = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			TreeNode node = params[2].getNode();
			double value = 0;
			Data data = Data.getInstance();
			Variable repCount = new Variable("repcount", false);
			data.addVariable(repCount);
			for(int i = 0; i < expression; i++) {
				value = ExpressionTree.getInstance().process(turtle, node);
				repCount.setValue(i+1);
			}
			return value;
		} else {
			super.commandInputError(this.getName());
			return -1;
		}
	}
}