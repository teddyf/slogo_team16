/**
 * This is the class for the SETPENSIZE command
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

public class SetPenSize extends Command {
	private final double paramCount;
	
	public SetPenSize() {
		super();
		numParams = 2;
		paramCount = 1;
	}
	
	/**
	 * Sets the size of the pen to be a certain thickness in pixels
	 * @param params - array of parameters
	 * @return the pen thickness in pixels
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double pixels = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		Data.getInstance().setPenSize((int)pixels);
		return pixels;
	}
}