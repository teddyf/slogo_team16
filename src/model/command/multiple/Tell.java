package model.command.multiple;

import java.util.ArrayList;

import Controller.Data;
import Parsing.TreeNode;
import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;

public class Tell extends Command {
	private final double paramCount;
	
	public Tell() {
		super();
		numParams = 1;
		paramCount = 0;
	}
	
	/**
	 * Sets the turtles that will follow the commands
	 * @param params - array of parameters
	 * @return last value in the turtles list
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		ArrayList<TreeNode> turtles = params[1].getNodes();
		for (int t = 0; t < turtles.size(); t++) {
			
		}
		return Data.getInstance().getNumTurtles();
	}
}