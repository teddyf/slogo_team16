package model.command.math.trigonometry;

import Parsing.ExpressionTree;
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
		double degrees = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		return atan(degrees);
	}
}