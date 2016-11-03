/**
 * This is the class for the IF command
 * 
 * @author Aninda Manocha
 */

package model.command.control.selection;

import Parsing.TreeNode;
import Parsing.expression.ConstantExpression;
import Parsing.expression.ExpressionTree;
import Parsing.expression.VariableExpression;
import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;

public class If extends Command {
	private final double paramCount;
	
	public If() {
		super();
		numParams = 3;
		paramCount = Double.POSITIVE_INFINITY; //was 2
	}
	
	/**
	 * Runs commands if a given expression is not 0
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
			if (expression != 0) {
				value = ExpressionTree.getInstance().process(turtle, node);
				return value;
			} else {
				return 0;
			}
		} else {
			super.commandInputError(this.getName());
			return -1;
		}
	}
}