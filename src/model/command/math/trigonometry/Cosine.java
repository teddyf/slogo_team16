/**
 * This is the class for the COSINE command
 * 
 * @author Aninda Manocha
 */

package model.command.math.trigonometry;

import Parsing.ConstantExpression;
import Parsing.ExpressionTree;
import Parsing.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;

public class Cosine extends MathTrigonometry {
	private final double paramCount;
	
	public Cosine() {
		super();
		numParams = 2;
		paramCount = 1;
	}

	/**
	 * Determines the cosine of a value in degrees
	 * @param params - array of parameters
	 * @return the cosine value
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression))) {
			double degrees = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			return cos(degrees);
		} else {
			super.commandInputError(this.getName());
			return -1;
		}
	}
}