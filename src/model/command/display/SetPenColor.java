/**
 * This is the class for the SETPENCOLOR command
 * 
 * @author Aninda Manocha
 */
package model.command.display;

import Controller.Data;
import Parsing.ConstantExpression;
import Parsing.ExpressionTree;
import Parsing.VariableExpression;
import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;

public class SetPenColor extends Command {
	private final double paramCount;
	
	public SetPenColor() {
		super();
		numParams = 2;
		paramCount = 1;
	}
	
	/**
	 * Sets the pen color to the color corresponding to a given index
	 * @param params - array of parameters
	 * @return the color index
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression))) {
			double index = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			Data.getInstance().setPenColor((int)index);
			return index;
		} else {
			super.commandInputError(this.getName());
			return -1;
		}
	}
}