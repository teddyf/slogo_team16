package model.command.control.variable;

import Controller.Data;
import Parsing.ExpressionTree;
import model.animal.Animal;
import model.command.Command;
import model.command.Parameter;
import model.command.control.ControlCommand;
import model.variable.Variable;

public class Make extends Command {
	private final double paramCount;
	
	public Make() {
		super();
		numParams = 3;
		paramCount = 2;
	}
	
	/**
	 * Assigns a value to a variable or creates the variable if it doesn't already exist
	 * @param params - array of parameters
	 * @return the value of the variable
	 */
	@Override
	public double run(Parameter[] params) {
		Animal turtle = params[0].getAnimal();
		String variableName = params[1].getNode().toString();
		double expression = ExpressionTree.getInstance().process(turtle, params[2].getNode());
		Data data = Data.getInstance();
		
		if (data.containsVariable(variableName)) {
			data.changeVariable(variableName, expression);
		} else {
			data.addVariable(new Variable(variableName, expression));
		}
		System.out.println("returning " + expression);
		return expression;
	}
}