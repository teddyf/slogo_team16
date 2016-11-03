/**
 * This is the class for the SETSHAPE command
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

public class SetShape extends Command {
	private final double paramCount;
	
	public SetShape() {
		super();
		numParams = 2;
		paramCount = 1;
	}
	
	/**
	 * Sets the shape of the turtle to the shape corresponding to a given index
	 * @param params - array of parameters
	 * @return the given index
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression))) {
			double index = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			Data.getInstance().setShape((int)index);
			return index;
		} else {
			super.commandInputError(this.getName());
			return -1;
		}
	}
}