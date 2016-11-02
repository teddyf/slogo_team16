/**
 * This is the class for the SINE command
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
			Errors.getInstance().displayError("Data Type Error!", "Invalid Data Entered", 
					"The wrong type of input has been entered into the sine command.");
			return -1;
		}
	}
}