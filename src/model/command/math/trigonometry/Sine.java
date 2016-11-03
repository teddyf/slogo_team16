/**
 * This is the class for the SINE command
 * 
 * @author Aninda Manocha
 */

package model.command.math.trigonometry;

import Parsing.expression.ConstantExpression;
import Parsing.expression.ExpressionTree;
import Parsing.expression.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;

public class Sine extends MathTrigonometry {
	private final double paramCount;
	
	public Sine() {
		super();
		numParams = 2;
		paramCount = 1;
	}

	/**
	 * Determines the sine of a value in degrees
	 * @param params - array of parameters
	 * @return the sine value
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression))) {
			double degrees = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			return sin(degrees);
		} else {
			super.commandInputError(this.getName());
			return -1;
		}
	}
}