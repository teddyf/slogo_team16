/**
 * This is the class for the SETPALETTE command
 * 
 * @author Aninda Manocha
 */

package model.command.display;

import Controller.Data;
import Parsing.expression.ConstantExpression;
import Parsing.expression.ExpressionTree;
import Parsing.expression.VariableExpression;
import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;

public class SetPalette extends Command {
	private final double paramCount;
	
	public SetPalette() {
		super();
		numParams = 5;
		paramCount = 4;
	}
	
	/**
	 * Sets the color at a given index to a color corresponding to given r g b values
	 * @param params - array of parameters
	 * @return the color index
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression))
				&& ((params[2].getNode().expression instanceof ConstantExpression) || (params[2].getNode().expression instanceof VariableExpression))
				&& ((params[3].getNode().expression instanceof ConstantExpression) || (params[3].getNode().expression instanceof VariableExpression))
				&& ((params[4].getNode().expression instanceof ConstantExpression) || (params[4].getNode().expression instanceof VariableExpression))) {
			double index = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			double r = ExpressionTree.getInstance().process(turtle, params[2].getNode());
			double g = ExpressionTree.getInstance().process(turtle, params[3].getNode());
			double b = ExpressionTree.getInstance().process(turtle, params[4].getNode());
			Data.getInstance().setPalette((int)index, (int)r, (int)g, (int)b);
			return index;
		} else {
			super.commandInputError(this.getName());
			return -1;
		}
	}
}