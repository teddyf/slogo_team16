/**
 * This is the class for the RANDOM command
 * 
 * @author Aninda Manocha
 */

package model.command.math.number;

import ErrorHandling.Errors;
import Parsing.ConstantExpression;
import Parsing.ExpressionTree;
import Parsing.VariableExpression;
import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;

public class Random extends Command {
	private final double paramCount;
	
	public Random() {
		super();
		numParams = 2;
		paramCount = 1;
	}

	/**
	 * Reports a random non-negative number strictly less than a maximum value
	 * @param params - array of parameters
	 * @return the random number
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		if (((params[1].getNode().expression instanceof ConstantExpression) || (params[1].getNode().expression instanceof VariableExpression))) {
			double max = ExpressionTree.getInstance().process(turtle, params[1].getNode());
			return Math.random()*max;
		} else {
			Errors.getInstance().displayError("Data Type Error!", "Invalid Data Entered", 
					"The wrong type of input has been entered into the random command.");
			return -1;
		}
	}
}