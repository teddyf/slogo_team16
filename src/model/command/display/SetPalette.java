package model.command.display;

import Controller.Data;
import Parsing.ExpressionTree;
import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;

public class SetPalette extends Command {
	private final double paramCount;
	
	public SetPalette() {
		super();
		numParams = 5;
		paramCount = 4;
	}
	
	/**
	 * Sets the color at a given index to a color corresponding to given r g b values
	 * @param params - array of parameters
	 * @return the color index
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		double index = ExpressionTree.getInstance().process(turtle, params[1].getNode());
		double r = ExpressionTree.getInstance().process(turtle, params[2].getNode());
		double g = ExpressionTree.getInstance().process(turtle, params[3].getNode());
		double b = ExpressionTree.getInstance().process(turtle, params[4].getNode());
		Data.getInstance().setPalette((int)index, (int)r, (int)g, (int)b);
		return index;
	}
}