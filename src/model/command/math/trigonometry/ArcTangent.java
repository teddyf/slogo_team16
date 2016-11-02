/**
 * This is the class for the ARCTANGENT command
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

public class ArcTangent extends MathTrigonometry {
	private final double paramCount;
	
	public ArcTangent() {
		super();
		numParams = 2;
		paramCount = 1;
	}

	/**
	 * Determines the arc tangent of a value in degrees
	 * @param params - array of parameters
	 * @return the arc tangent value
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression))) {
			double degrees = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			return atan(degrees);
		} else {
			Errors.getInstance().displayError("Data Type Error!", "Invalid Data Entered", 
					"The wrong type of input has been entered into the arctangent command.");
			return -1;
		}
	}
}