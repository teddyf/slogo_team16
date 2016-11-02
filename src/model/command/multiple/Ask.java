/**
 * This is the class for the ASK command
 * 
 * @author Aninda Manocha
 */

package model.command.multiple;

import java.util.ArrayList;

import Controller.Data;
import Parsing.ExpressionTree;
import Parsing.TreeNode;
import model.animal.Animal;
import model.command.ListCommand;
import model.command.Parameter;

public class Ask extends ListCommand {
	private final double paramCount;
	
	public Ask() {
		super();
		numParams = 3;
		paramCount = 2;
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
		TreeNode node = params[2].getNode();
		ArrayList<Double> IDs = new ArrayList<Double>();
		for (int t = 0; t < turtles.size(); t++) {
			IDs.add(ExpressionTree.getInstance().process(turtle, turtles.get(t)));
		}
		for (int t = 0; t < Data.getInstance().getTurtles().size(); t++) {
			int id = (int)(Data.getInstance().getTurtles().get(t).getId());
			if (IDs.contains(id)) {
				Data.getInstance().getTurtles().get(t).setSelected(true);
				IDs.remove(1.0*id);
			} else {
				Data.getInstance().getTurtles().get(t).setSelected(false);
			}
		}
		return ExpressionTree.getInstance().process(turtle, node);
	}
	
	@Override
	public double getNumParams() {
		return numParams;
	}
}