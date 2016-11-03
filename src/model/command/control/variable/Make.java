/**
 * This is the class for the MAKE/SET command
 * 
 * @author Aninda Manocha
 */

package model.command.control.variable;

import Controller.Data;
import Parsing.ConstantExpression;
import Parsing.ExpressionTree;
import Parsing.VariableExpression;
import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;
import model.variable.Variable;

public class Make extends Command {
	private final double paramCount;
	
	public Make() {
		super();
		numParams = 3;
		paramCount = 2;
	}
	
	/**
	 * Assigns a value to a variable or creates the variable if it doesn't already exist
	 * @param params - array of parameters
	 * @return the value of the variable
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		String variableName = params[1].getNode().toString();
		if (((params[2].getNode().expression instanceof ConstantExpression) || (params[2].getNode().expression instanceof VariableExpression))) {
			double expression = ExpressionTree.getInstance().process(turtle, params[2].getNode());
			Data data = Data.getInstance();
			if (data.containsVariable(variableName)) {
				if (data.getVariable(variableName).getValue() != expression) {
					data.changeVariable(variableName, expression);
				}
			} else {
				data.addVariable(new Variable(variableName, expression, false));
			}
			return expression;
		} else {
			super.commandInputError(this.getName());
			return -1;
		}
	}
}