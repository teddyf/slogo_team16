/**
 * This is the class for the TANGENT command
 * 
 * @author Aninda Manocha
 */

package model.command.math.trigonometry;

import ErrorHandling.Errors;
import Parsing.ConstantExpression;
import Parsing.ExpressionTree;
import Parsing.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;

public class Tangent extends MathTrigonometry {
	private final double paramCount;
	
	public Tangent () {
		super();
		numParams = 2;
		paramCount = 1;
	}

	/**
	 * Determines the tangent of a value in degrees
	 * @param params - array of parameters 
	 * @return the tangent value
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression))) {
			double degrees = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			if (degrees == 90) {
				return Double.POSITIVE_INFINITY;
			}
			if (degrees == 270) {
				return Double.NEGATIVE_INFINITY;
			}
			return sin(degrees)/cos(degrees);
		} else {
			Errors.getInstance().displayError("Data Type Error!", "Invalid Data Entered", 
					"The wrong type of input has been entered into the tangent command.");
			return -1;
		}
	}
}