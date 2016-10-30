package model.command.math.trigonometry;

import Parsing.ExpressionTree;
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
		double degrees = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		if (degrees == 90) {
			return Double.POSITIVE_INFINITY;
		}
		if (degrees == 270) {
			return Double.NEGATIVE_INFINITY;
		}
		return sin(degrees)/cos(degrees);
	}
}