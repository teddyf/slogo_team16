/**
 * This is the class for the TOWARDS command
 * 
 * @author Aninda Manocha
 */

package model.command.turtle.rotation;

import Parsing.expression.ConstantExpression;
import Parsing.expression.ExpressionTree;
import Parsing.expression.VariableExpression;
import model.animal.Animal;
import model.command.Parameter;

public class Towards extends TurtleRotation {
	private final double paramCount;
	
	public Towards() {
		super();
		numParams = 3;
		paramCount = 2;
	}

	/**
	 * Turns the animal to face an absolute screen position
	 * @param params - array of parameters
	 * @return the number of degrees moved
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double x = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		double y = ExpressionTree.getInstance().process(turtle, params[2].getNode());
		return turnTo(turtle, x, y);
	}
}